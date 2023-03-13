package com.example.lesson_42_springboot;

import com.example.service.CounterService;
import com.example.service.impl.CounterServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lesson42SpringBootApplication {

    @Bean
    CounterService counterService(){
        return new CounterServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(Lesson42SpringBootApplication.class, args);
    }

}
