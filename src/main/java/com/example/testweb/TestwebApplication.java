package com.example.testweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"com.example.testweb"} ) // entities package name
public class TestwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestwebApplication.class, args);
    }

}
