package com.example.weather.classes;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class WeatherInformation {
    private int id;
    private int cityId;
    private BigDecimal temperature;
    private BigDecimal windSpeed;
    private BigDecimal humidity;
    private Timestamp dateTime;

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

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
