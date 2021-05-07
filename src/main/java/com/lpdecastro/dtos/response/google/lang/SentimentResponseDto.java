/**
 *
 */
package com.lpdecastro.dtos.response.google.lang;

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
public class SentimentResponseDto {

    @JsonProperty("magnitude")
    private Float magnitude;

    @JsonProperty("score")
    private Float score;
}
