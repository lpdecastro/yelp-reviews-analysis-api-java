package com.lpdecastro.exceptions;

import lombok.Getter;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/16
 */
@Getter
public class YelpReviewsException
        extends RuntimeException {

    private static final long serialVersionUID = 625708243305653570L;

    private final String message;

    public YelpReviewsException(String message) {
        super(message);
        this.message = message;
    }
}
