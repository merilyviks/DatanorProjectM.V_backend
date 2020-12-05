package com.example.weather.scheduledtasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Scheduled(fixedRate = 900000)
    public void askInformation(){

    }
}
