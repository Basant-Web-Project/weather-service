package com.sapient.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class NextDayForecast {
    private List<String> warnMessages;
    private int avg_humidity;
    private double max_temp;
    private Double winds;
    private String date;
    private String time;
}
