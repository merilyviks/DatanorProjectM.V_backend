package com.example.weather.controller;


import com.example.weather.classes.CityNames;
import com.example.weather.service.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherInformationController {
    @Autowired
    private WeatherInformationService weatherInformationService;

    @CrossOrigin
    @PostMapping("addcityname")
    public void addCityName (@RequestBody CityNames cityNames) {
        weatherInformationService.addCityName(cityNames);
    }




}
