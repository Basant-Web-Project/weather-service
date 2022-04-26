package com.sapient.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastReport {
    private String cityName;
    private Map<String, List<NextDayForecast>> forecastMap;
}
