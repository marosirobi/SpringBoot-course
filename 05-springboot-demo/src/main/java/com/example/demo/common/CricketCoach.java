package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("Constructor: " + getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Daily 25 minutes of cricket";
    }


}
