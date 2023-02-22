package org.example.service.impl;

import org.example.entity.Bet;
import org.example.entity.Horse;
import org.example.entity.Pair;
import org.example.entity.Result;
import org.example.entity.Rider;
import org.example.service.GameService;
import org.example.service.MoneyService;
import org.example.service.PairService;
import org.example.service.RaceService;
import org.example.service.ResultChecker;

import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class GameServiceImpl implements GameService {
    private final MoneyService moneyService;
    private final RaceService raceService;
    private final ResultChecker resultChecker;

   private final PairService pairService;
    private  final Bet bet;

    public GameServiceImpl(MoneyService moneyService, RaceService raceService, ResultChecker resultChecker, Bet bet,PairService pairService ) {
        this.raceService = raceService;
        this.moneyService = moneyService;
        this.resultChecker = resultChecker;
        this.bet =bet;
        this.pairService = pairService;

    }

    @Override
    public Result start() throws NoSuchPairException {
        int pairNumber = bet.getNumberOfPair();

        if(pairNumber<=0||pairNumber>(pairService.getPairs().size())){
            throw new NoSuchPairException();
        }
        Pair chosen =  pairService.getPairs().get((pairNumber - 1));
        int moneyBet = bet.getBet();
        moneyService.setMoney(moneyBet);
        List<Pair> result = raceService.go(pairService.getPairs());
        boolean isWinner = resultChecker.isWinner(result, chosen);

        if (isWinner) {
            moneyService.multiplyMoney();
        } else {
            moneyService.subtractMoney(moneyBet);
        }

        return new Result(moneyService.getMoney(), isWinner);

    }

}
