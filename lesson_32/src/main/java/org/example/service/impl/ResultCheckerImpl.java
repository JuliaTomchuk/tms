package org.example.service.impl;

import org.example.entity.Pair;
import org.example.service.ResultChecker;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
@Service
public class ResultCheckerImpl implements ResultChecker {


    @Override
    public boolean isWinner(List<Pair> participants, Pair chosen) {

        Pair pair = participants.stream().max((Pair o1, Pair o2) -> o2.getPairSpeed() - o1.getPairSpeed()).get();

        return chosen.equals(pair);
    }
}