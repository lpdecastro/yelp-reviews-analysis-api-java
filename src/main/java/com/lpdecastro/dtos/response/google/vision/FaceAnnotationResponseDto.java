package com.lpdecastro.dtos.response.google.vision;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceAnnotationResponseDto {

    @JsonProperty("joyLikelihood")
    private String joyLikelihood;

    @JsonProperty("sorrowLikelihood")
    private String sorrowLikelihood;

    @JsonProperty("angerLikelihood")
    private String angerLikelihood;

    @JsonProperty("surpriseLikelihood")
    private String surpriseLikelihood;

    @JsonProperty("underExposedLikelihood")
    private String underExposedLikelihood;

    @JsonProperty("blurredLikelihood")
    private String blurredLikelihood;

    @JsonProperty("headwearLikelihood")
    private String headwearLikelihood;
}
