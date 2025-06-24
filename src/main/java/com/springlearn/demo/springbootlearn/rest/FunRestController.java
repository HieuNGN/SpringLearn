package com.springlearn.demo.springbootlearn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Autowired
    private InfoEndpoint infoEndpoint;

    @Autowired
    private HealthEndpoint healthEndpoint;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    //expose new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return "100 pushups! Now! For king and queen";
    }

    //expose endpoint for assets
    @GetMapping("/assets")
    public String getAssets() {
        return "your assets: 0";
    }

    @GetMapping("/info")
    public Object getInfo() {
        return infoEndpoint.info();
    }
    @GetMapping("/health")
    public Object getHealth() {
        return healthEndpoint.health();
    }

}
