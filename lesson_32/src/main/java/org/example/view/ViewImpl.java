package org.example.view;

import org.example.entity.Pair;
import org.example.entity.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViewImpl implements View {
    @Override
    public void printResult(int circle, List<Pair> pairs) {

        System.out.println(circle + " круг итог:");
        int place =1;

        for (Pair pair : pairs) {
            System.out.println(place + " место: " + pair);
            place++;
        }

    }

    @Override
    public void printResult(Result result) {
        if (result.isWinner()) {
            System.out.println("Поздравляю!!! Вы выиграли!!!");
            System.out.println("Деньги:" + result.getMoney());
            System.out.println("Хотите продолжить игру? 1 - да, 0 - нет");

        } else {
            System.out.println("Вы проиграли");
            System.out.println("Деньги:" + result.getMoney());
            System.out.println("Хотите продолжить игру? 1 - да, 0 - нет");
        }
    }
}
