/**
 *
 */
package com.lpdecastro.dtos.response.yelp.business;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/07
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("price")
    private String price;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("is_closed")
    private Boolean isClosed;

    @JsonProperty("categories")
    private List<CategoryResponseDto> categories;

    @JsonProperty("review_count")
    private Integer reviewCount;

    @JsonProperty("url")
    private String url;

    @JsonProperty("coordinates")
    private CoordinatesResponseDto coordinates;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("location")
    private LocationResponseDto location;

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("transactions")
    private List<String> transactions;
}
