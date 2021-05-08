/**
 *
 */
package com.lpdecastro.dtos.response;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ReviewWithAnalysisResponseDto {

    @JsonProperty("text")
    private String text;

    @JsonProperty("imageUrl")
    private URL imageUrl;

    @JsonProperty("analysis")
    private AnalysisResponseDto analysis;
}
