package com.example.weather.scheduledtasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTasks {
    @Scheduled(fixedRate = 900000)
    public void askInformation() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn&appid=463d7eba8561093a975ed69dca7bd5c0";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        System.out.println(root);
        JsonNode name = root.get("wind").get("speed");
        System.out.println(name);
        JsonNode temperature = root.get("main").get("temp");
        System.out.println(temperature);
        JsonNode humidity = root.get("main").get("humidity");
        System.out.println(humidity);







        }

    }


