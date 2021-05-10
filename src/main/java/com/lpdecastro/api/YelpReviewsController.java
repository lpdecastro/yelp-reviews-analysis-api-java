package com.lpdecastro.api;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lpdecastro.dtos.request.YelpReviewsRequestDto;
import com.lpdecastro.dtos.response.YelpReviewsResponseDto;
import com.lpdecastro.services.YelpReviewsService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/07
 */
@Slf4j
@RestController
@Validated
public class YelpReviewsController {

    @Autowired
    private YelpReviewsService service;

    @Autowired
    private Validator validator;

    @GetMapping(path = "/yelp/business/reviews",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public YelpReviewsResponseDto getYelpReviewsController(
            @RequestParam Map<String, String> params) {

        YelpReviewsRequestDto reqDto = new YelpReviewsRequestDto(params);

        final Set<ConstraintViolation<YelpReviewsRequestDto>> violations = validator.validate(reqDto);
        if (!violations.isEmpty()) {
            LOGGER.warn("Request form validation failed.");
            throw new ConstraintViolationException(violations);
        }

        return service.getBusinessReviews(reqDto);
    }
}
