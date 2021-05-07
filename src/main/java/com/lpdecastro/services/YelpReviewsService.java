package com.lpdecastro.services;

import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessSearchResponseDto;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/07
 */
public interface YelpReviewsService {

    BusinessSearchResponseDto getBusinessReviews(YelpReviewsRequestDto reqDto);
}
