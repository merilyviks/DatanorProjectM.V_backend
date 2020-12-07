package com.example.weather.repository;


import com.example.weather.classes.CityNames;
import com.example.weather.rowmapper.CityNamesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        return jdbcTemplate.query(sql, new CityNamesRowMapper());
    }

    public void deleteCityName(String cityName) {
        String sql = "DELETE FROM city_names WHERE city_name=(:value1)";
        Map<String, Object> cityNameMap= new HashMap<>();
        cityNameMap.put("value1", cityName);
        jdbcTemplate.update(sql, cityNameMap);

    }





}
