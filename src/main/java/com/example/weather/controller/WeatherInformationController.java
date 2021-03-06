package com.example.weather.controller;


import com.example.weather.classes.CityNames;
import com.example.weather.classes.WeatherInformation;
import com.example.weather.service.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherInformationController {
    @Autowired
    private WeatherInformationService weatherInformationService;

    @CrossOrigin
    @PostMapping("addcityname")
    public void addCityName (@RequestBody CityNames cityNames) {
        weatherInformationService.addCityName(cityNames);
    }

    @CrossOrigin
    @GetMapping ("getallcitynames")
    public List<CityNames> getAllCityNames () {
        return weatherInformationService.getAllCityNames();
    }

    @CrossOrigin
    @GetMapping ("getallweatherinfo")
    public List<WeatherInformation> getAllWeatherInfo () {
        return weatherInformationService.getAllWeatherInfo();
    }

    @CrossOrigin
    @DeleteMapping ("deletecity")
    public void deleteCityName (@RequestParam String cityName) {
        weatherInformationService.deleteCityName(cityName);
    }




}
