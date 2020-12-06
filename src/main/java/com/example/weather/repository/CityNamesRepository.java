package com.example.weather.repository;


import com.example.weather.classes.CityNames;
import com.example.weather.rowmapper.CityNamesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CityNamesRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addCityName(String cityName){
        String sql = "INSERT INTO city_names (city_name) VALUES (:value1)";
        Map<String, Object> cityNameMap= new HashMap<>();
        cityNameMap.put("value1", cityName);
        jdbcTemplate.update(sql, cityNameMap);
    }

    public List<CityNames> getAllCityNames(){
        String sql = "SELECT * FROM city_names";
       Object miski= jdbcTemplate.query(sql, new CityNamesRowMapper());
        return (List<CityNames>) miski;
    }

    public void setWeatherInformation(int cityId, int temperature, int windSpeed, int humidity, int dateTime) {
        String sql = "INSERT INTO account_nr (city_id, temperature, wind_speed, humidity, date_time)"
                                    + "VALUES (:muutuja1, :muutuja2, :muutuja3, :muutuja4, :muutuja5)";
        Map<String, Object> cityNameMap= new HashMap<>();
        cityNameMap.put("value1", cityId);
    }



}
