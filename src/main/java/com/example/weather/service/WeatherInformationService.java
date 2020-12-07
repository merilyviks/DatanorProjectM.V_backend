package com.example.weather.service;

import com.example.weather.classes.CityNames;
import com.example.weather.repository.CityNamesRepository;
import com.example.weather.repository.WeatherInformationRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherInformationService {
    @Autowired
    private CityNamesRepository cityNamesRepository;

    @Autowired
    private WeatherInformationRepository weatherInformationRepository;


    @Autowired
    private RestTemplate restTemplate;

    public void addCityName(CityNames cityNames) {
        String cityName = cityNames.getCityName();
        cityNamesRepository.addCityName(cityName);
    }

    public List<CityNames> getAllCityNames() {
        return cityNamesRepository.getAllCityNames();
    }

    public void deleteCityName (String cityName) {
        cityNamesRepository.deleteCityName(cityName);
    }


    public void setInformationfromAPI(int cityId, BigDecimal kelvintemperature, BigDecimal windSpeed, BigDecimal humidity) {
        //BigDecimal kelvinToCelcius = new BigDecimal(273.15);

        BigDecimal temperature = kelvintemperature.divide(BigDecimal.valueOf(273.15));
        Timestamp dateTime = Timestamp.valueOf(LocalDateTime.now());
        weatherInformationRepository.setWeatherInformation(cityId, temperature, windSpeed, humidity, dateTime);


    }



}
