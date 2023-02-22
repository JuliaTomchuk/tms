package org.example.service;

import org.example.entity.Horse;
import org.example.entity.Pair;
import org.example.entity.Rider;

import java.util.List;

public interface PairService {

    void savePair(Horse horse, Rider rider);
    List<Pair> getPairs();
}
