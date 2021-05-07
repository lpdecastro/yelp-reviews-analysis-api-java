package com.lpdecastro.dtos.request.google.vision;

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
public class FeatureRequestDto {

    @JsonProperty("type")
    private String type;

    @JsonProperty("maxResults")
    private Integer maxResults;

    @JsonProperty("model")
    private String model;
}
