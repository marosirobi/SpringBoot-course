package com.example.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println("Constructor: " + getClass().getName());
    }

    @PostConstruct
    public void doMyStuffConstruct(){
        System.out.println( "startup method: " + getClass().getName());
    }

    @PreDestroy
    public void doMyStuffDestroy(){
        System.out.println( "destroy method: " + getClass().getName());
    }


    @Override
    public String getDailyWorkout() {
        return "Daily 25 minutes of tennis";
    }


}
