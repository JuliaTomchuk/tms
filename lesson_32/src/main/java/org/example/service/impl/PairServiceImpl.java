package org.example.service.impl;

import org.example.entity.Horse;
import org.example.entity.Pair;
import org.example.entity.Rider;
import org.example.service.PairService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
@SessionScope
public class PairServiceImpl implements PairService {

    private final List<Pair> participants = new CopyOnWriteArrayList<>();
    @Override
    public void savePair(Horse horse, Rider rider) {
        Pair pair = new Pair(horse,rider);
        participants.add(pair);

    }

    @Override
    public List<Pair> getPairs() {

        return participants;
    }
}
