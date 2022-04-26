package com.sapient.weather.service;

import com.sapient.weather.dto.WeatherForecastReport;
import com.sapient.weather.dto.WeatherResponse;
import com.sapient.weather.exception.WeatherServiceBusinessException;

import java.util.List;

public interface WeatherService {

    public WeatherForecastReport findWeatherForCity(String city) throws WeatherServiceBusinessException;
}
