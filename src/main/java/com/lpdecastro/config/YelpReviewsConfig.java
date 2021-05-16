/**
 *
 */
package com.lpdecastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/12
 */
@PropertySource("classpath:application.properties")
@Configuration
public class YelpReviewsConfig {

    private static final String BEARER = "Bearer ";

    @Bean("yelpApiClient")
    public WebClient yelpApiClient(YelpApiConfig yelpApiConfig) {
        return WebClient.builder()
                .baseUrl(yelpApiConfig.getBaseUrl())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, BEARER + yelpApiConfig.getApiKey())
                .build();
    }

    @Bean("cloudVisionApiClient")
    public WebClient cloudVisionApiClient(GoogleApiConfig googleVisionApiConfig) {
        return WebClient.builder()
                .baseUrl(googleVisionApiConfig.getVisionBaseUrl())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + googleVisionApiConfig.getApiKey())
                .build();
    }

    @Bean("naturalLangApiClient")
    public WebClient naturalLangApiClient(GoogleApiConfig googleVisionApiConfig) {
        return WebClient.builder()
                .baseUrl(googleVisionApiConfig.getLanguageBaseUrl())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + googleVisionApiConfig.getApiKey())
                .build();
    }
}
