package org.example.service.impl;

import org.example.entity.Pair;
import org.example.service.RaceService;
import org.example.service.ResultChecker;
import org.example.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceServiceImpl implements RaceService {


    private ResultChecker resultChecker;
    private View view;

    public RaceServiceImpl(ResultChecker resultChecker, View view) {
        this.resultChecker = resultChecker;
        this.view = view;
    }

    private Random random = new Random();

    @Override
    public List<Pair> go(List<Pair> participants) {
        int counter = 1;
        List<Pair> result = new ArrayList<>();
        while (counter < 6) {

            for (int i = 0; i < participants.size(); i++) {
                int speed = participants.get(i).getPairSpeed();
                speed = speed + random.nextInt(0, 20);
                participants.get(i).setPairSpeed(speed);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            result = participants;
            result = resultChecker.getResult(result);
            view.printResult(counter, result);
            counter++;
        }

        return result;

    }


}
