package com.lpdecastro.utils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.response.google.lang.NaturalLanguageResponseDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessSearchResponseDto;
import com.lpdecastro.dtos.response.yelp.reviews.ReviewsResponseDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/05
 */
@Slf4j
public class WebClientUtility {

    private static final String LOG_TEMPLATE = "{}::{}() - {}";

    private final WebClient webClient;

    public WebClientUtility(String baseUrl, String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .build();
    }

    public BusinessSearchResponseDto executeYelpApiBusinessSearchRequest(String path, YelpReviewsRequestDto reqDto) {
        try {
            return this.webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(path)
                            .queryParamIfPresent("term", Optional.ofNullable(reqDto.getTerm()))
                            .queryParamIfPresent("location", Optional.ofNullable(reqDto.getLocation()))
                            .queryParamIfPresent("latitude", Optional.ofNullable(reqDto.getLatitude()))
                            .queryParamIfPresent("longitude", Optional.ofNullable(reqDto.getLongitude()))
                            .queryParamIfPresent("radius", Optional.ofNullable(reqDto.getRadius()))
                            .queryParamIfPresent("categories", Optional.ofNullable(reqDto.getCategories()))
                            .queryParamIfPresent("locale", Optional.ofNullable(reqDto.getLocale()))
                            // .queryParamIfPresent("limit", Optional.ofNullable(reqDto.getLimit()))
                            .queryParamIfPresent("limit", Optional.of(3))
                            .queryParamIfPresent("offset", Optional.ofNullable(reqDto.getOffset()))
                            .queryParamIfPresent("sort_by", Optional.ofNullable(reqDto.getSortBy()))
                            .queryParamIfPresent("price", Optional.ofNullable(reqDto.getPrice()))
                            .queryParamIfPresent("open_now", Optional.ofNullable(reqDto.getOpenNow()))
                            .queryParamIfPresent("open_at", Optional.ofNullable(reqDto.getOpenAt()))
                            .queryParamIfPresent("attributes", Optional.ofNullable(reqDto.getAttributes()))
                            .build())
                    .retrieve()
                    .bodyToMono(BusinessSearchResponseDto.class)
                    .toFuture()
                    .join();

        } catch (WebClientResponseException | CompletionException | CancellationException ex) {
            ex.printStackTrace(); // TODO: replaced with LOGGER
            throw new RuntimeException(); // TODO: replaced with custom exception
        }
    }

    public Mono<ReviewsResponseDto> executeYelpApiReviewsSearchRequest(String bizId, String locale) {
        try {
            return this.webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(String.format("/%s/reviews", bizId))
                            .queryParamIfPresent("locale", Optional.ofNullable(locale))
                            .build())
                    .retrieve()
                    .bodyToMono(ReviewsResponseDto.class);

        } catch (WebClientResponseException | CompletionException | CancellationException ex) {
            ex.printStackTrace(); // TODO: replaced with LOGGER
            throw new RuntimeException(); // TODO: replaced with custom exception
        }
    }

    public List<ReviewsResponseDto> executeYelpApiReviewsSearchRequest(List<String> bizIds, String locale) {
        try {
            return Flux.fromIterable(bizIds)
                    .parallel()
                    .runOn(Schedulers.boundedElastic())
                    .flatMap(bizId -> executeYelpApiReviewsSearchRequest(bizId, locale))
                    .sequential()
                    .collectList()
                    .block();

        } catch (WebClientResponseException | CompletionException | CancellationException ex) {
            ex.printStackTrace(); // TODO: replaced with LOGGER
            throw new RuntimeException(); // TODO: replaced with custom exception
        }
    }

    public Mono<NaturalLanguageResponseDto> executeGoogleNatLangApiRequest(String requestsString) {
        try {
            return this.webClient.post()
                    .bodyValue(requestsString)
                    .retrieve()
                    .bodyToMono(NaturalLanguageResponseDto.class);

        } catch (WebClientResponseException | CompletionException | CancellationException ex) {
            ex.printStackTrace(); // TODO: replaced with LOGGER
            throw new RuntimeException(); // TODO: replaced with custom exception
        }
    }

    public List<NaturalLanguageResponseDto> executeGoogleNatLangApiRequest(List<String> requestsStrings) {
        try {
            return Flux.fromIterable(requestsStrings)
                    .parallel()
                    .runOn(Schedulers.boundedElastic())
                    .flatMap(requestsString -> executeGoogleNatLangApiRequest(requestsString))
                    .sequential()
                    .collectList()
                    .block();

        } catch (WebClientResponseException | CompletionException | CancellationException ex) {
            ex.printStackTrace(); // TODO: replaced with LOGGER
            throw new RuntimeException(); // TODO: replaced with custom exception
        }
    }

}
