package com.example.shelter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shelter.mapper")
public class ShelterRevolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelterRevolutionApplication.class, args);
    }
}
