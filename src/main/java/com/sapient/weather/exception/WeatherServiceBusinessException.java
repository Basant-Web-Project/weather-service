package com.sapient.weather.exception;

public class WeatherServiceBusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public WeatherServiceBusinessException(String message){
		super(message);
	}
}
