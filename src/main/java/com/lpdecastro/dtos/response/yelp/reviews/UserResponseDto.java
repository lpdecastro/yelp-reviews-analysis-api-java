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
public class UserResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("profile_url")
    private URL profileUrl;

    @JsonProperty("image_url")
    private URL imageUrl;

    @JsonProperty("name")
    private String name;
}
