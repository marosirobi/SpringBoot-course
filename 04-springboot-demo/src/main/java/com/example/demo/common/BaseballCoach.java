package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("Constructor: " + getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "25 minutes of baseball";
    }
}
