package org.example.view;

import org.example.entity.Pair;
import org.example.entity.Result;

import java.util.List;

public interface View {

    void printResult(int circle, List<Pair> pairs);

    void printResult(Result result);
}
