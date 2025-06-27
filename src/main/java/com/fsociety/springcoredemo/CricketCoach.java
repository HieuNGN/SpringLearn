package com.fsociety.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Fast Bowling for 30mins now!!!";
    }
}
