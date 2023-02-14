package org.example;


import org.example.service.GameService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.example");


        GameService gameService = context.getBean(GameService.class);
        gameService.start();

        context.close();

    }

}

