package com.example.demo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("Constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "swimming with coach";
    }
}
