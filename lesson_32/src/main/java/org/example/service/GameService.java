package org.example.service;


import org.example.entity.Bet;
import org.example.entity.Pair;
import org.example.entity.Result;

import java.util.List;

public interface GameService {
    Result start(Bet bet, List<Pair> pairs);
}
