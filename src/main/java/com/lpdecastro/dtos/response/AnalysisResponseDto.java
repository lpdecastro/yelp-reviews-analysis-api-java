/**
 *
 */
package com.lpdecastro.dtos.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lpdecastro.dtos.response.google.lang.NaturalLanguageResponseDto;
import com.lpdecastro.dtos.response.google.vision.FaceAnnotationResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/08
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnalysisResponseDto {

    @JsonProperty("emotions")
    private List<FaceAnnotationResponseDto> emotions;

    @JsonProperty("sentiments")
    private NaturalLanguageResponseDto sentiments;
}
