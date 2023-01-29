package org.example.service.impl;

import org.example.entity.Pair;
import org.example.entity.PairComparator;
import org.example.service.ResultChecker;


import java.util.List;

public class ResultCheckerImpl implements ResultChecker {
    @Override
    public List<Pair> getResult(List<Pair> participants) {

        participants.sort(new PairComparator());

        return participants;
    }

    @Override
    public boolean isWinner(List<Pair> participants, Pair chosen) {
        return chosen.equals(participants.get(0));
    }


}
