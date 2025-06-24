package com.springlearn.demo.springbootlearn;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ActuatorConfig {
    @Bean
    public BuildProperties buildProperties() {
        Properties properties = new Properties();
        properties.put("name", "Spring Boot Learn Demo");
        properties.put("version", "1.0.0");
        properties.put("group", "com.springlearn.demo");
        return new BuildProperties(properties);
    }

}
