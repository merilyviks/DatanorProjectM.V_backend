package com.example.weather.rowmapper;

import java.time.LocalDateTime;
import com.example.weather.classes.WeatherInformation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class WeatherInfoRowMapper implements RowMapper<WeatherInformation> {

    @Override
    public WeatherInformation mapRow(ResultSet resultSet, int i) throws SQLException {
        WeatherInformation weatherInformation = new WeatherInformation();
        weatherInformation.setCityId(resultSet.getInt("city_id"));
        weatherInformation.setTemperature(resultSet.getBigDecimal("temperature"));
        weatherInformation.setWindSpeed(resultSet.getBigDecimal("wind_speed"));
        weatherInformation.setHumidity(resultSet.getBigDecimal("humidity"));
        weatherInformation.setDateTime(resultSet.getTimestamp("date_time"));
        return weatherInformation;
    }
}