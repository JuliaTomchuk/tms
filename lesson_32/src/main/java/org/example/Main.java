package org.example;


import org.example.service.GameService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");


        GameService gameService = context.getBean(GameService.class);
        gameService.start();

        context.close();

    }

}

