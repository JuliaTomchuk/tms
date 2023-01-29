package org.example.service.impl;

import org.example.entity.Pair;
import org.example.service.GameService;
import org.example.service.MoneyService;
import org.example.service.RaceService;
import org.example.service.ResultChecker;
import org.example.view.View;


import java.util.List;
import java.util.Scanner;

public class GameServiceImpl implements GameService {
    private MoneyService moneyService;
    private RaceService raceService;

    private ResultChecker resultChecker;
    private View view;


    public GameServiceImpl(MoneyService moneyService, RaceService raceService, ResultChecker resultChecker, View view) {
        this.raceService = raceService;
        this.moneyService = moneyService;
        this.resultChecker = resultChecker;
        this.view = view;

    }

    @Override
    public void start(List<Pair> participants) {

        System.out.println("Веберите номер пары от 1 до 3");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Веберите номер пары от 1 до 3");
        }
        int pairNumber = scanner.nextInt();
        Pair chosen = participants.get((pairNumber - 1));

        System.out.println(participants);

        System.out.println("Сделайте ставку");

        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Сделайте ставку");
        }

        int bet = scanner.nextInt();
        moneyService.setMoney(bet);


        List<Pair> result = raceService.go(participants);

        boolean isWinner = resultChecker.isWinner(result, chosen);

        if (isWinner) {
            moneyService.multiplyMoney();
        } else {
            moneyService.subtractMoney(bet);
        }
        view.printResult(moneyService.getMoney(), isWinner);

    }
}
