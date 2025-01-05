package com.nitesh.exceptions;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import static io.micronaut.http.HttpStatus.NOT_FOUND;

@Produces
@Singleton
@Requires(classes = {UserNotFoundException.class, ExceptionHandler.class})
public class UserNotFoundExceptionHandler implements ExceptionHandler<UserNotFoundException,
        HttpResponse<ErrorResponse>>{

    @Override
    public HttpResponse<ErrorResponse> handle(HttpRequest request, UserNotFoundException exception) {
        ErrorResponse response = new ErrorResponse(NOT_FOUND, exception.getMessage());
        return HttpResponse.notFound(response);
    }
}
