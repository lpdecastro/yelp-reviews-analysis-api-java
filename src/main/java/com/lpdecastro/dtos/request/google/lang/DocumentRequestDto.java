/**
 *
 */
package com.lpdecastro.dtos.request.google.lang;

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
public class DocumentRequestDto {

    @JsonProperty("type")
    private String type;

    @JsonProperty("content")
    private String content;
}
