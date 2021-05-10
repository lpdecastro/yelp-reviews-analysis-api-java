/**
 *
 */
package com.lpdecastro.dtos.response;

import java.util.List;

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

    private List<YelpReviewResponseDto> test;
}