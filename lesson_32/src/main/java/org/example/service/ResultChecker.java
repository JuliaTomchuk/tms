package org.example.service;

import org.example.entity.Pair;

import java.util.List;

public interface ResultChecker {


    boolean isWinner(List<Pair> participants, Pair chosen);
}


