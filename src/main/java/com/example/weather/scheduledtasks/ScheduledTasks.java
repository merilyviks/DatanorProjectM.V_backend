package com.example.weather.scheduledtasks;

import com.example.weather.service.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduledTasks {
    @Autowired
    private WeatherInformationService weatherInformationService;

    @Scheduled(fixedRate = 900000) //900000
    public void scheduledAskInformation() {
        weatherInformationService.askInformation();
        }

    }


