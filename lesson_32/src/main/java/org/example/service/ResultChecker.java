package org.example.service;

import org.example.entity.Pair;

import java.util.List;

public interface ResultChecker {

    List<Pair> getResult(List<Pair> participants);

    boolean isWinner(List<Pair> participants, Pair chosen);
}


