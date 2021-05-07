package com.lpdecastro.dtos.response.yelp.reviews;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/05
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private URL url;

    @JsonProperty("text")
    private String text;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("time_reated")
    private String timeCreated;

    @JsonProperty("user")
    private UserResponseDto user;
}
