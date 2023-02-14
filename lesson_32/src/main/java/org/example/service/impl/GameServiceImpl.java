package org.example.service.impl;

import org.example.entity.Pair;
import org.example.entity.Result;
import org.example.service.GameService;
import org.example.service.MoneyService;
import org.example.service.RaceService;
import org.example.service.ResultChecker;
import org.example.view.View;
import org.springframework.stereotype.Service;




import java.util.List;
import java.util.Scanner;
@Service
public class GameServiceImpl implements GameService {
    private final MoneyService moneyService;
    private final RaceService raceService;

    private final ResultChecker resultChecker;
    private final View view;
    private final List<Pair> participants;



    public GameServiceImpl(List<Pair> participants,MoneyService moneyService, RaceService raceService, ResultChecker resultChecker, View view) {
        this.raceService = raceService;
        this.moneyService = moneyService;
        this.resultChecker = resultChecker;
        this.view = view;
        this.participants =participants;


    }

    @Override
    public void start() {

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
        view.printResult(new Result(moneyService.getMoney(),isWinner));
        continueGame();

    }

    private void continueGame(){
         Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            scanner.nextLine();
        }
        int result= scanner.nextInt();
        if(result==1){
            start();
        }
    }
}
