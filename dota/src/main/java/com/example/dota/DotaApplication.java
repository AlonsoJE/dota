package com.example.dota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DotaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotaApplication.class, args);
    }
}
