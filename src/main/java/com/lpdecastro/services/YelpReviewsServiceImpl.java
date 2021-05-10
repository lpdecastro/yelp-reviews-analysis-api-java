package com.lpdecastro.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpdecastro.config.GoogleApiConfig;
import com.lpdecastro.config.YelpApiConfig;
import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.request.google.lang.DocumentRequestDto;
import com.lpdecastro.dtos.response.AnalysisResponseDto;
import com.lpdecastro.dtos.response.ReviewWithAnalysisResponseDto;
import com.lpdecastro.dtos.response.YelpReviewResponseDto;
import com.lpdecastro.dtos.response.YelpReviewsResponseDto;
import com.lpdecastro.dtos.response.google.lang.NaturalLanguageResponseDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessResponseDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessSearchResponseDto;
import com.lpdecastro.dtos.response.yelp.reviews.ReviewsResponseDto;
import com.lpdecastro.utils.WebClientUtility;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/05
 */
@Service
public class YelpReviewsServiceImpl implements YelpReviewsService {

    @Autowired
    private YelpApiConfig yelpApiConfig;

    @Autowired
    private GoogleApiConfig googleVisionApiConfig;

    @Override
    public YelpReviewsResponseDto getBusinessReviews(YelpReviewsRequestDto reqDto) {

        // Logic 1: Business Search
        WebClientUtility yelpClient = new WebClientUtility(yelpApiConfig.getBaseUrl(), yelpApiConfig.getApiKey());

        BusinessSearchResponseDto bizs = yelpClient.executeYelpApiBusinessSearchRequest("/search", reqDto);

        // Logic 2: Get Business Id
        List<String> bizIds = retrieveBusinessIds(bizs);

        // Logic 3: Reviews Search
        List<ReviewsResponseDto> bizReviews = yelpClient.executeYelpApiReviewsSearchRequest(bizIds, reqDto.getLocale());

        // for (ReviewsResponseDto bizReviewsItem : bizReviews) {
        // // Logic 4: Get Review
        // List<String> bizReview = retrieveBusinessReviewTexts(bizReviewsItem);
        //
        // // Logic 5: Google Analysis
        // WebClientUtility googleNatLangClient = new WebClientUtility(googleVisionApiConfig.getLanguageBaseUrl(),
        // googleVisionApiConfig.getApiKey());
        //
        // List<NaturalLanguageResponseDto> sentiments = googleNatLangClient.executeGoogleNatLangApiRequest(bizReview);
        //
        // }

        // Mapping:
        List<YelpReviewResponseDto> resList = new ArrayList<>();

        for (int i = 0; i < bizIds.size(); i++) {
            YelpReviewResponseDto resItem = new YelpReviewResponseDto();
            resItem.setName(bizs.getBusinesses().get(i).getName());

            // Logic 4: Get Review
            List<DocumentRequestDto> bizReviewDto = retrieveBusinessReviewTexts(bizReviews.get(i));

            List<String> bizReview = bizReviewDto.stream()
                    .map(bizReviewDtoItem -> {
                        try {
                            return new ObjectMapper().writeValueAsString(bizReviewDtoItem);
                        } catch (JsonProcessingException ex) {
                            ex.printStackTrace(); // TODO: replaced with LOGGER
                            throw new RuntimeException(); // TODO: replaced with custom exception
                        }
                    })
                    .collect(Collectors.toList());

            for (String testItem : bizReview) {
                System.out.println("TESTING IN");
                System.out.println(testItem);
            }

            // Logic 5: Google Analysis
            WebClientUtility googleNatLangClient = new WebClientUtility(googleVisionApiConfig.getLanguageBaseUrl(),
                    googleVisionApiConfig.getApiKey());

            List<NaturalLanguageResponseDto> sentiments = googleNatLangClient.executeGoogleNatLangApiRequest(bizReview);

            for (NaturalLanguageResponseDto testItem : sentiments) {
                System.out.println("OUT");
                System.out.println(testItem);
            }

            List<ReviewWithAnalysisResponseDto> reviewWithAnalysis = new ArrayList<>();
            for (int j = 0; j < bizReviews.get(i).getReviews().size(); j++) {
                ReviewWithAnalysisResponseDto reviewWithAnalysisItem = new ReviewWithAnalysisResponseDto();
                String text = bizReviews.get(i).getReviews().get(j).getText();
                URL imageUrl = bizReviews.get(i).getReviews().get(j).getUser().getImageUrl();
                AnalysisResponseDto analysis = new AnalysisResponseDto();
                analysis.setSentiments(sentiments.get(j));

                reviewWithAnalysisItem.setText(text);
                reviewWithAnalysisItem.setImageUrl(imageUrl);
                reviewWithAnalysisItem.setAnalysis(analysis);
                reviewWithAnalysis.add(reviewWithAnalysisItem);
            }

            resItem.setReviews(reviewWithAnalysis);
            resList.add(resItem);
        }

        return new YelpReviewsResponseDto(resList);
    }

    private List<String> retrieveBusinessIds(BusinessSearchResponseDto businessSearch) {
        return businessSearch.getBusinesses().stream().map(BusinessResponseDto::getId).collect(Collectors.toList());
    }

    private List<DocumentRequestDto> retrieveBusinessReviewTexts(ReviewsResponseDto bizReview) {
        return bizReview.getReviews().stream()
                .map(bizReviewItem -> {
                    DocumentRequestDto doc = new DocumentRequestDto();
                    doc.setType("PLAIN_TEXT");
                    doc.setContent(bizReviewItem.getText());
                    return doc;
                })
                .collect(Collectors.toList());
    }
}
