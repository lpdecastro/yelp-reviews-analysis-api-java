package com.lpdecastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdecastro.config.GoogleApiConfig;
import com.lpdecastro.config.YelpApiConfig;
import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.response.yelp.business.BusinessSearchResponseDto;
import com.lpdecastro.utils.WebClientUtility;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/05
 */
@Service
public class YelpReviewsServiceImpl implements YelpReviewsService {

    @Autowired
    private YelpApiConfig yelpApiConfig;

    @Autowired
    private GoogleApiConfig googleVisionApiConfig;

    @Override
    public BusinessSearchResponseDto getBusinessReviews(YelpReviewsRequestDto reqDto) {

        WebClientUtility yelpClient = new WebClientUtility(yelpApiConfig.getBaseUrl(), yelpApiConfig.getApiKey());

        return yelpClient.executeYelpApiBusinessSearchRequest("/search", reqDto);
    }
}
