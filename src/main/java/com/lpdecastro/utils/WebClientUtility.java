package com.lpdecastro.utils;

import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessSearchResponseDto;

import lombok.extern.slf4j.Slf4j;

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
                            .queryParamIfPresent("limit", Optional.ofNullable(reqDto.getLimit()))
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
}
