package pt.fjrcorreia.playground.spring.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Francisco Correia
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ApiErrorResponse handleNotFoundException(NullPointerException ex) {

        ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(HttpStatus.NOT_FOUND)
                .withError_code("NOT_FOUND")
                .withMessage("Me Bitch").build();

        return response;
    }



}