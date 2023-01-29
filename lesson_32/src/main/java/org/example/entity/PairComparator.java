package org.example.entity;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.getPairSpeed() - o1.getPairSpeed();
    }
}
