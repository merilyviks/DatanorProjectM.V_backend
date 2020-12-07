package com.example.weather.service;

import com.example.weather.classes.CityNames;
import com.example.weather.classes.WeatherInformation;
import com.example.weather.repository.CityNamesRepository;
import com.example.weather.repository.WeatherInformationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public List<WeatherInformation> getAllWeatherInfo() {
        return weatherInformationRepository.getAllWeatherInfo();
    }

    public void deleteCityName (String cityName) {
        cityNamesRepository.deleteCityName(cityName);
    }


    public void askInformation() {
        String APIkey = "463d7eba8561093a975ed69dca7bd5c0";
        int howManyCityNames = getAllCityNames().size();
        String cityName = "";
        int cityId = 0;
        for (int i = 0; i<howManyCityNames; i++) {
            cityName = getAllCityNames().get(i).getCityName();
            cityId = getAllCityNames().get(i).getId();
            String url = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+APIkey+"";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode()==HttpStatus.OK ) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = null;
                try {
                    root = mapper.readTree(response.getBody());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                BigDecimal kelvintemperature = root.get("main").get("temp").decimalValue();
                BigDecimal wind = (root.get("wind").get("speed")).decimalValue();
                BigDecimal humidity = root.get("main").get("humidity").decimalValue();
                BigDecimal temperature = kelvintemperature.divide(BigDecimal.valueOf(273.15), RoundingMode.HALF_UP);
                weatherInformationRepository.setWeatherInformation(cityId, temperature, wind, humidity);
            }

        }
    }
}




