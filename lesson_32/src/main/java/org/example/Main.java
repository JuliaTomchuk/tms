package org.example;

import org.example.entity.Pair;
import org.example.service.GameService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        Pair pair1 = context.getBean("pair1", Pair.class);
        Pair pair2 = context.getBean("pair2", Pair.class);
        Pair pair3 = context.getBean("pair3", Pair.class);

        List<Pair> pairs = new ArrayList<>();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);

        GameService gameService = context.getBean(GameService.class);
        gameService.start(pairs);

        context.close();
















       }


        }

