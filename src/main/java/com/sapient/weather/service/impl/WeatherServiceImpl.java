package com.sapient.weather.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.weather.dto.List;
import com.sapient.weather.dto.NextDayForecast;
import com.sapient.weather.dto.WeatherForecastReport;
import com.sapient.weather.dto.WeatherResponse;
import com.sapient.weather.exception.WeatherServiceBusinessException;
import com.sapient.weather.service.WeatherService;
import com.sapient.weather.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.root.url}")
    private String apiUrl;
    @Value("${weather.api.appId}")
    private String appId;
    private static final String responseType = "&mode=json&units=metric"; //mode

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public WeatherForecastReport findWeatherForCity(String city) throws WeatherServiceBusinessException {
        String reqUrl = new StringBuilder(apiUrl)
                .append(city)
                .append(responseType)
                .append("&appid=" + appId).toString();
        log.info("Request URL {}", reqUrl);
        try {
            WeatherResponse weatherResponse = restTemplate.getForObject(reqUrl, WeatherResponse.class);
            return buildForecastResponse(weatherResponse);
        }catch (Exception exception){
            throw new WeatherServiceBusinessException("Weather api not working !");
        }
    }

    private WeatherForecastReport buildForecastResponse(WeatherResponse weatherResponse) {
        log.info("Response from weather api " + mapToJson(weatherResponse));
        String next3DayDate = ApplicationUtils.getLastDate(3).split(" ")[0];
        WeatherForecastReport forecastReport = new WeatherForecastReport();
        forecastReport.setCityName(weatherResponse.getCity().getName());
        Map<String, java.util.List<NextDayForecast>> forecastMap = null;
        java.util.List<NextDayForecast> forecastList = new ArrayList<>();
        for (List list : weatherResponse.getList()) {
            String dateFromAPI = list.getDtTxt().split(" ")[0];
            String timeFromAPI = list.getDtTxt().split(" ")[1];
            if (dateFromAPI.equals(next3DayDate)) {
                break;
            }
            Double tempMax = list.getMain().getTempMax();
            Double windSpeed = list.getWind().getSpeed();
            Integer humidity = list.getMain().getHumidity();
            forecastList.add(NextDayForecast.build(ApplicationUtils.forecastHealth(tempMax, windSpeed),
                    humidity, tempMax, windSpeed, dateFromAPI, timeFromAPI));
        }
        forecastMap = forecastList.stream().collect(Collectors.groupingBy(NextDayForecast::getDate))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        ;
        forecastReport.setForecastMap(forecastMap);
        log.info("Response from buildForecastResponse method {}", forecastReport);
        return forecastReport;
    }

    private String mapToJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
