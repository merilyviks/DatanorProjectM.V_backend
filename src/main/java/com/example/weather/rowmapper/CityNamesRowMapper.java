package com.example.weather.rowmapper;

import com.example.weather.classes.CityNames;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CityNamesRowMapper implements RowMapper<CityNames> {

    @Override
    public CityNames mapRow(ResultSet resultSet, int i) throws SQLException {
        CityNames cityNames = new CityNames();
        cityNames.setId(resultSet.getInt("id"));
        cityNames.setCityName(resultSet.getString("city_name"));
        return cityNames;
    }
}
