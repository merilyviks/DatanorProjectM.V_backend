package com.example.weather.service;

import com.example.weather.classes.CityNames;
import com.example.weather.repository.CityNamesRepository;
import com.example.weather.repository.WeatherInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        //restTemplate.
    }

    public void getInformationfromAPI() {
        int listSize = cityNamesRepository.getAllCityNames().size();

        String cityName = "";
        for(int i = 0; i<listSize; i++){
            //weatherInformationRepository
        }

    }



}
