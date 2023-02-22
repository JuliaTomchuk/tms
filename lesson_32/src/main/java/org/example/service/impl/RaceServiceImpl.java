package org.example.service.impl;

import org.example.aop.Benchmark;
import org.example.entity.Pair;
import org.example.service.RaceService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Random;

@Service
public class RaceServiceImpl implements RaceService {
    private Random random = new Random();

    @Override
    @Benchmark
    public List<Pair> go(List<Pair> participants) {
        int counter = 1;
        while (counter < 6) {

            for (int i = 0; i < participants.size(); i++) {
                int speed = participants.get(i).getPairSpeed();
                speed = speed + random.nextInt(0, 20);
                participants.get(i).setPairSpeed(speed);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }

        return participants;

    }

}
