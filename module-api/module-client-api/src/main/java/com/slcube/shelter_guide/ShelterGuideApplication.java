package com.slcube.shelter_guide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(value = "com.slcube.shelter_guide")
public class ShelterGuideApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShelterGuideApplication.class, args);
    }
}