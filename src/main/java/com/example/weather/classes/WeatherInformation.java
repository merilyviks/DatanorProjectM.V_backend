package com.example.weather.classes;

import java.time.LocalTime;

public class WeatherInformation {
    private int id;
    private int cityId;
    private int temperature;
    private int windSpeed;
    private int humidity;
    private LocalTime dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }
}
