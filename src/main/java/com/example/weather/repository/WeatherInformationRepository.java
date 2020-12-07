package com.example.weather.repository;

import com.example.weather.classes.CityNames;
import com.example.weather.classes.WeatherInformation;
import com.example.weather.rowmapper.CityNamesRowMapper;
import com.example.weather.rowmapper.WeatherInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WeatherInformationRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setWeatherInformation(int cityId, BigDecimal temperature, BigDecimal windSpeed, BigDecimal humidity) {
        String sql = "INSERT INTO weather_information (city_id, temperature, wind_speed, humidity, date_time)"
                + "VALUES (:value1, :value2, :value3, :value4, :value5)";
        Map<String, Object> weatherMap= new HashMap<>();
        weatherMap.put("value1", cityId);
        weatherMap.put("value2", temperature);
        weatherMap.put("value3", windSpeed);
        weatherMap.put("value4", humidity);
        weatherMap.put("value5", LocalDateTime.now());
        jdbcTemplate.update(sql, weatherMap);
    }

    public List<WeatherInformation> getAllWeatherInfo(){
        String sql = "SELECT * FROM weather_information";
        return  jdbcTemplate.query(sql, new WeatherInfoRowMapper());
    }


}
