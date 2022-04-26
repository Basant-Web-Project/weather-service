package com.sapient.weather.advice;

import com.sapient.weather.exception.WeatherError;
import com.sapient.weather.exception.WeatherServiceBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class WeatherServiceAdvice {

    @ExceptionHandler(WeatherServiceBusinessException.class)
    public ResponseEntity<WeatherError> handleException(WeatherServiceBusinessException e) {
        WeatherError error = new WeatherError();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<WeatherError> handleException(RestClientException e) {
        WeatherError error = new WeatherError();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
