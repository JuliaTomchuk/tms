package org.example.view;

import org.example.entity.Pair;

import java.util.List;

public interface View {

    void printResult(int circle, List<Pair> pairs);

    void printResult(int money, boolean isWinner);
}
