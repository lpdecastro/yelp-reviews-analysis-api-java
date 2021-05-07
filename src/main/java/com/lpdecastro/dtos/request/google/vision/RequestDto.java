package com.lpdecastro.dtos.request.google.vision;

import java.util.List;

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
public class RequestDto {

    @JsonProperty("image")
    private ImageRequestDto image;

    @JsonProperty("features")
    private List<FeatureRequestDto> features;
}
