/**
 *
 */
package com.lpdecastro.dtos.response.google.lang;

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
public class NaturalLanguageResponseDto {

    @JsonProperty("documentSentiment")
    private DocumentSentimentResponseDto documentSentiment;

    @JsonProperty("language")
    private String language;

    @JsonProperty("sentences")
    private List<SentenceResponseDto> sentences;
}
