package com.lpdecastro.dtos.response.google.vision;

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
public class FaceAnnotationsResponseDto {

    @JsonProperty("faceAnnotations")
    private List<FaceAnnotationResponseDto> faceAnnotations;
}
