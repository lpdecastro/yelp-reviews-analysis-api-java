/**
 *
 */
package com.lpdecastro.dtos.response;

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
public class YelpReviewsResponseDto {

    @JsonProperty("businesses")
    private List<YelpReviewResponseDto> businesses;
}
