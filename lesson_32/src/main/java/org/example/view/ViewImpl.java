package org.example.view;

import org.example.entity.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViewImpl implements View {
    @Override
    public void printResult(int circle, List<Pair> pairs) {

        System.out.println(circle + " круг итог:");

        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(i + 1 + " место: " + pairs.get(i));
        }

    }

    @Override
    public void printResult(int money, boolean isWinner) {
        if (isWinner) {
            System.out.println("Поздравляю!!! Вы выиграли!!!");
            System.out.println("Деньги:" + money);

        } else {
            System.out.println("Вы проиграли");
            System.out.println("Деньги:" + money);
        }
    }
}
