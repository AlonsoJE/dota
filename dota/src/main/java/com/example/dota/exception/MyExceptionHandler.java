package com.example.dota.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @Value("${var.exception.notFound}")
    private String notFoundMessage;

    @Value("${var.exception.badRequest}")
    private String badResquest;

    // 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> basic(HttpMessageNotReadableException r){
        ApiError exception = new ApiError(400, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> basic(BadRequestException r){
        ApiError exception = new ApiError(400, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> basic(MethodArgumentTypeMismatchException r){
        ApiError exception = new ApiError(400, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<?> teste(HttpClientErrorException.Unauthorized r){
        ApiError exception = new ApiError(401, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<?> teste(HttpClientErrorException.Forbidden r){
        ApiError exception = new ApiError(403, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> basic(ResourceNotFoundException r){
        ApiError exception = new ApiError(404, LocalDateTime.now(), r.getClass().getName(),  String.valueOf(r.getCause()), r.getMessage(), notFoundMessage);
        return new ResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.UnsupportedMediaType.class)
    public ResponseEntity<?> teste(HttpClientErrorException.UnsupportedMediaType r){
        ApiError exception = new ApiError(415, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpClientErrorException.TooManyRequests.class)
    public ResponseEntity<?> teste(HttpClientErrorException.TooManyRequests r){
        ApiError exception = new ApiError(429, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.TOO_MANY_REQUESTS);
    }

    //500
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<?> basic(HttpServerErrorException.InternalServerError r){
        ApiError exception = new ApiError(500, LocalDateTime.now(), r.getClass().getName(), String.valueOf(r.getCause()), r.getMessage(), badResquest);
        return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }







}
