package com.example.weather.repository;

import com.example.weather.rowmapper.WeatherInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WeatherInformationRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setWeatherInformation(int cityId, BigDecimal temperature, BigDecimal windSpeed, BigDecimal humidity, Timestamp dateTime) {
        String sql = "INSERT INTO account_nr (city_id, temperature, wind_speed, humidity, dateTime)"
                + "VALUES (:muutuja1, :muutuja2, :muutuja3, :muutuja4, :muutuja5)";
        Map<String, Object> weatherMap= new HashMap<>();
        weatherMap.put("value1", cityId);
        weatherMap.put("value2", temperature);
        weatherMap.put("value3", windSpeed);
        weatherMap.put("value4", humidity);
        weatherMap.put("value5", dateTime);

        jdbcTemplate.query(sql, weatherMap, new WeatherInfoRowMapper());
    }


}
