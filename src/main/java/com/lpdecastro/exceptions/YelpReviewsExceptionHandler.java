package com.lpdecastro.exceptions;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path.Node;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lpdecastro.dtos.error.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/16
 */
@Slf4j
@RestControllerAdvice
public class YelpReviewsExceptionHandler
        extends ResponseEntityExceptionHandler {

    private static final String LOGGER_TEMPLATE = "{}::{}() - {}";

    private static final String KEY_EXCEPTION = "exception";

    @ExceptionHandler(YelpReviewsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleAleHouseReviewsException(YelpReviewsException ex) {
        LOGGER.error(LOGGER_TEMPLATE, getClass().getSimpleName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

        return getResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleConstraintViolationException(ConstraintViolationException ex) {
        final ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());

        final Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (final ConstraintViolation<?> error : violations) {
            LOGGER.debug(error.getPropertyPath() + ": " + error.getMessage());

            String field = "";
            final Iterator<Node> iter = error.getPropertyPath().iterator();
            while (iter.hasNext()) {
                final Node n = iter.next();
                final ElementKind kind = n.getKind();
                if (kind.equals(ElementKind.PARAMETER) || kind.equals(ElementKind.PROPERTY)) {
                    field = n.getName();
                }
            }

            errorResponse.addDetail(field, error.getMessage());
        }

        return errorResponse;
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error(LOGGER_TEMPLATE, getClass().getSimpleName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

        return getResponseEntity(status, ex.getLocalizedMessage(), headers);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error(LOGGER_TEMPLATE, getClass().getSimpleName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

        return getResponseEntity(status, ex.getLocalizedMessage(), headers);
    }

    private final ResponseEntity<Object> getResponseEntity(HttpStatus status, String message) {
        return getResponseEntity(status, message, new HttpHeaders());
    }

    private final ResponseEntity<Object> getResponseEntity(HttpStatus status, String message, HttpHeaders headers) {
        final ErrorResponseDto response = new ErrorResponseDto(
                status.value(), status.getReasonPhrase());

        response.addDetail(KEY_EXCEPTION, message);
        return new ResponseEntity<>(response, headers, status);
    }
}
