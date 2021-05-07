package com.lpdecastro.dtos.response.yelp.business;

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
public class CategoryResponseDto {

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("title")
    private String title;
}
