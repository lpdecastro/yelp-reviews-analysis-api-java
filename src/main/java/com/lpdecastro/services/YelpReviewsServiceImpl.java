package com.lpdecastro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.request.google.lang.DocumentRequestDto;
import com.lpdecastro.dtos.request.google.vision.FeatureRequestDto;
import com.lpdecastro.dtos.request.google.vision.ImageRequestDto;
import com.lpdecastro.dtos.request.google.vision.RequestDto;
import com.lpdecastro.dtos.request.google.vision.RequestsDto;
import com.lpdecastro.dtos.request.google.vision.SourceRequestDto;
import com.lpdecastro.dtos.response.AnalysisResponseDto;
import com.lpdecastro.dtos.response.ReviewWithAnalysisResponseDto;
import com.lpdecastro.dtos.response.YelpReviewResponseDto;
import com.lpdecastro.dtos.response.YelpReviewsResponseDto;
import com.lpdecastro.dtos.response.google.lang.NaturalLanguageResponseDto;
import com.lpdecastro.dtos.response.google.vision.FaceAnnotationResponseDto;
import com.lpdecastro.dtos.response.google.vision.VisionResponseDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessResponseDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessSearchResponseDto;
import com.lpdecastro.dtos.response.yelp.reviews.ReviewsResponseDto;
import com.lpdecastro.exceptions.YelpReviewsException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/05
 */
@Slf4j
@Service
public class YelpReviewsServiceImpl implements YelpReviewsService {

    private static final String LOG_TEMPLATE = "{}::{}() - {}";

    @Autowired
    @Qualifier("yelpApiClient")
    private WebClient yelpApiClient;

    @Autowired
    @Qualifier("cloudVisionApiClient")
    private WebClient cloudVisionApiClient;

    @Autowired
    @Qualifier("naturalLangApiClient")
    private WebClient naturalLangApiClient;

    private final ObjectMapper jsonMapper = Jackson2ObjectMapperBuilder.json().build();

    @Override
    public YelpReviewsResponseDto getBusinessReviews(YelpReviewsRequestDto reqDto) {

        // Part 1 - Sequential API Calls to Yelp Business Search API and Reviews Search API
        YelpReviewsResponseDto resDto = callYelpApiBusinessSearchMono(reqDto)
                .zipWhen(bizs -> callYelpApiReviewsSearchMono(bizs, reqDto), this::yelpApiResultCombinator)
                .toFuture()
                .join();

        // Part 2 - Generate Cloud Vision API and Natural Language API Request
        List<RequestsDto> visionApiRequestList = new ArrayList<>();
        List<List<DocumentRequestDto>> langApiRequestList = new ArrayList<>();
        mutateVisionAndLangRequest(resDto, visionApiRequestList, langApiRequestList);

        // Part 3 - Parallel API Calls to Cloud Vision API and Natural Language API
        return Mono
                .zip(callVisionApiMono(visionApiRequestList), callLangApiMono(langApiRequestList))
                .map(objects -> this.visionAndLangApiResultMapper(resDto, objects))
                .toFuture()
                .join();
    }

    /**
     * @param
     *
     * @return
     */
    private Mono<BusinessSearchResponseDto> callYelpApiBusinessSearchMono(YelpReviewsRequestDto reqDto) {

        return yelpApiClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParamIfPresent("term", Optional.ofNullable(reqDto.getTerm()))
                        .queryParamIfPresent("location", Optional.ofNullable(reqDto.getLocation()))
                        .queryParamIfPresent("latitude", Optional.ofNullable(reqDto.getLatitude()))
                        .queryParamIfPresent("longitude", Optional.ofNullable(reqDto.getLongitude()))
                        .queryParamIfPresent("radius", Optional.ofNullable(reqDto.getRadius()))
                        .queryParamIfPresent("categories", Optional.ofNullable(reqDto.getCategories()))
                        .queryParamIfPresent("locale", Optional.ofNullable(reqDto.getLocale()))
                        .queryParamIfPresent("limit", Optional.of(3)) // retrieve only 3 businesses
                        .queryParamIfPresent("offset", Optional.ofNullable(reqDto.getOffset()))
                        .queryParamIfPresent("sort_by", Optional.ofNullable(reqDto.getSortBy()))
                        .queryParamIfPresent("price", Optional.ofNullable(reqDto.getPrice()))
                        .queryParamIfPresent("open_now", Optional.ofNullable(reqDto.getOpenNow()))
                        .queryParamIfPresent("open_at", Optional.ofNullable(reqDto.getOpenAt()))
                        .queryParamIfPresent("attributes", Optional.ofNullable(reqDto.getAttributes()))
                        .build())
                .retrieve()
                .bodyToMono(BusinessSearchResponseDto.class)
                .onErrorResume(ex -> {
                    LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                            Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

                    return Mono.error(new YelpReviewsException("Call to external webservice failed."));
                });
    }

    /**
     * @param
     *
     * @return
     */
    private Mono<List<ReviewsResponseDto>> callYelpApiReviewsSearchMono(BusinessSearchResponseDto bizs,
            YelpReviewsRequestDto reqDto) {

        return Flux
                .fromIterable(
                        bizs.getBusinesses().stream().map(BusinessResponseDto::getId).collect(Collectors.toList()))
                .flatMapSequential(bizId -> yelpApiClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(String.format("/%s/reviews", bizId))
                                .queryParamIfPresent("locale", Optional.ofNullable(reqDto.getLocale()))
                                .build())
                        .retrieve()
                        .bodyToMono(ReviewsResponseDto.class)
                        .onErrorResume(ex -> {
                            LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                                    Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

                            return Mono.error(new YelpReviewsException("Call to external webservice failed."));
                        }))
                .collectList();
    }

    /**
     * @param
     *
     * @return
     */
    private YelpReviewsResponseDto yelpApiResultCombinator(BusinessSearchResponseDto bizs,
            List<ReviewsResponseDto> reviewsList) {

        List<YelpReviewResponseDto> businesses = new ArrayList<>();

        for (int i = 0; i < bizs.getBusinesses().size(); i++) {

            YelpReviewResponseDto business = new YelpReviewResponseDto();
            business.setName(bizs.getBusinesses().get(i).getName());

            List<ReviewWithAnalysisResponseDto> reviews = new ArrayList<>();

            for (int j = 0; j < reviewsList.get(i).getReviews().size(); j++) {
                ReviewWithAnalysisResponseDto review = new ReviewWithAnalysisResponseDto();
                review.setText(reviewsList.get(i).getReviews().get(j).getText());
                review.setImageUrl(reviewsList.get(i).getReviews().get(j).getUser().getImageUrl());

                reviews.add(review);
            }

            business.setReviews(reviews);
            businesses.add(business);
        }

        return new YelpReviewsResponseDto(businesses);
    }

    /**
     * @param
     *
     * @return
     */
    private void mutateVisionAndLangRequest(YelpReviewsResponseDto resDto,
            List<RequestsDto> cloudVisionApiRequestList,
            List<List<DocumentRequestDto>> naturalLangApiRequestList) {

        for (YelpReviewResponseDto business : resDto.getBusinesses()) {

            List<RequestDto> requests = new ArrayList<>();
            List<DocumentRequestDto> naturalLangApiRequests = new ArrayList<>();

            for (ReviewWithAnalysisResponseDto review : business.getReviews()) {
                // Configure Vision API Request
                List<FeatureRequestDto> features = new ArrayList<>();
                FeatureRequestDto feature = new FeatureRequestDto();
                feature.setType("FACE_DETECTION");
                feature.setMaxResults(10);
                features.add(feature);

                SourceRequestDto source = new SourceRequestDto();
                source.setImageUri(review.getImageUrl().toString());

                ImageRequestDto image = new ImageRequestDto();
                image.setSource(source);

                RequestDto request = new RequestDto();
                request.setImage(image);
                request.setFeatures(features);

                requests.add(request);

                // Configure Natural Language API Request
                DocumentRequestDto naturalLangApiRequest = new DocumentRequestDto();
                naturalLangApiRequest.setType("PLAIN_TEXT");
                naturalLangApiRequest.setContent(review.getText());

                naturalLangApiRequests.add(naturalLangApiRequest);
            }

            RequestsDto cloudVisionApiRequest = new RequestsDto(requests);
            cloudVisionApiRequestList.add(cloudVisionApiRequest);

            naturalLangApiRequestList.add(naturalLangApiRequests);
        }
    }

    /**
     * @param
     *
     * @return
     */
    private Mono<List<VisionResponseDto>> callVisionApiMono(List<RequestsDto> cloudVisionApiRequestList) {

        return Flux.fromIterable(cloudVisionApiRequestList)
                .flatMapSequential(req -> {
                    try {
                        return cloudVisionApiClient.post()
                                .bodyValue(jsonMapper.writeValueAsString(req))
                                .retrieve()
                                .bodyToMono(VisionResponseDto.class)
                                .onErrorResume(ex -> {
                                    LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                                            Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

                                    return Mono.error(new YelpReviewsException("Call to external webservice failed."));
                                });

                    } catch (JsonProcessingException ex) {
                        LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                                Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

                        throw new YelpReviewsException(ex.getLocalizedMessage());
                    }
                })
                .collectList();
    }

    /**
     * @param
     *
     * @return
     */
    private Mono<List<List<NaturalLanguageResponseDto>>> callLangApiMono(
            List<List<DocumentRequestDto>> naturalLangApiRequestList) {

        return Flux.fromIterable(naturalLangApiRequestList)
                .flatMapSequential(req -> Flux.fromIterable(req)
                        .flatMapSequential(reqItem -> {
                            try {
                                return naturalLangApiClient.post()
                                        .bodyValue(jsonMapper.writeValueAsString(reqItem))
                                        .retrieve()
                                        .bodyToMono(NaturalLanguageResponseDto.class)
                                        .onErrorResume(ex -> {
                                            LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                                                    Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

                                            return Mono.error(
                                                    new YelpReviewsException("Call to external webservice failed."));
                                        });

                            } catch (JsonProcessingException ex) {
                                LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                                        Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

                                throw new YelpReviewsException(ex.getLocalizedMessage());
                            }
                        })
                        .collectList())
                .collectList();
    }

    /**
     * @param
     *
     * @return
     */
    private YelpReviewsResponseDto visionAndLangApiResultMapper(YelpReviewsResponseDto resDto,
            Tuple2<List<VisionResponseDto>, List<List<NaturalLanguageResponseDto>>> objects) {

        List<YelpReviewResponseDto> businesses = resDto.getBusinesses();

        for (int i = 0; i < businesses.size(); i++) {

            List<ReviewWithAnalysisResponseDto> reviews = businesses.get(i).getReviews();

            for (int j = 0; j < reviews.size(); j++) {

                List<FaceAnnotationResponseDto> emotions = new ArrayList<>(
                        objects.getT1().get(i).getResponses().get(j).getFaceAnnotations());

                AnalysisResponseDto analysis = new AnalysisResponseDto();
                analysis.setEmotions(emotions); // Map Cloud Vision API Result
                analysis.setSentiments(objects.getT2().get(i).get(j)); // Map Natural Language API Result

                ReviewWithAnalysisResponseDto review = businesses.get(i).getReviews().get(j);
                review.setAnalysis(analysis);

                reviews.set(j, review);
                businesses.get(i).setReviews(reviews);
            }
            resDto.setBusinesses(businesses);
        }
        return resDto;
    }
}
