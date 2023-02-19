package org.example.service.impl;

import org.example.entity.Bet;
import org.example.entity.Pair;
import org.example.entity.Result;
import org.example.service.GameService;
import org.example.service.MoneyService;
import org.example.service.RaceService;
import org.example.service.ResultChecker;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final MoneyService moneyService;
    private final RaceService raceService;
    private final ResultChecker resultChecker;

    public GameServiceImpl(MoneyService moneyService, RaceService raceService, ResultChecker resultChecker) {
        this.raceService = raceService;
        this.moneyService = moneyService;
        this.resultChecker = resultChecker;

    }

    @Override
    public Result start(Bet bet, List<Pair> participants) {
        int pairNumber = bet.getNumberOfPair();
        Pair chosen = participants.get((pairNumber - 1));
        int moneyBet = bet.getBet();
        moneyService.setMoney(moneyBet);
        List<Pair> result = raceService.go(participants);
        boolean isWinner = resultChecker.isWinner(result, chosen);

        if (isWinner) {
            moneyService.multiplyMoney();
        } else {
            moneyService.subtractMoney(moneyBet);
        }

        return new Result(moneyService.getMoney(), isWinner);

    }
}
