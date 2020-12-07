package com.example.weather.scheduledtasks;

import com.example.weather.service.WeatherInformationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.compiler.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


@Component
public class ScheduledTasks {
    @Autowired
    private WeatherInformationService weatherInformationService;

    @Scheduled(fixedRate = 30000) //millisekundid 900000
    public void askInformation() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String APIkey = "463d7eba8561093a975ed69dca7bd5c0";
        int howManyCityNames = weatherInformationService.getAllCityNames().size();
        System.out.println("Linnasid"+howManyCityNames);
        String cityName = "";
        int cityId = 0;

        for (int i = 0; i<howManyCityNames; i++) {
            cityName = weatherInformationService.getAllCityNames().get(i).getCityName();
            cityId = weatherInformationService.getAllCityNames().get(i).getId();

            String url = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+APIkey+"";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                if (response.getStatusCode()==HttpStatus.OK ) {
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode root = mapper.readTree(response.getBody());
                    BigDecimal kelvintemperature = root.get("main").get("temp").decimalValue();
                    BigDecimal wind = (root.get("wind").get("speed")).decimalValue();
                    BigDecimal humidity = root.get("main").get("humidity").decimalValue();
                    weatherInformationService.setInformationfromAPI(cityId, kelvintemperature, wind, humidity);
                }
                else{
                    System.out.println("ups");
                }


            }
        }

    }


