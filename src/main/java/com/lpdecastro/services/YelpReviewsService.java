package com.lpdecastro.services;

import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.response.YelpReviewsResponseDto;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/07
 */
public interface YelpReviewsService {

    YelpReviewsResponseDto getBusinessReviews(YelpReviewsRequestDto reqDto);
}
