package com.sapient.weather.controller;

import com.sapient.weather.dto.WeatherForecastReport;
import com.sapient.weather.exception.WeatherServiceBusinessException;
import com.sapient.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-service")
public class WeatherForecastController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/next3days/{city}")
    public ResponseEntity<WeatherForecastReport> findWeatherForecastByCity(@PathVariable String city) throws WeatherServiceBusinessException {
        return ResponseEntity.ok(weatherService.findWeatherForCity(city));
    }
}


