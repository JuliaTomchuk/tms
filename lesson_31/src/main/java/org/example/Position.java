package org.example;

public enum Position {
    DIRECTOR(2), WORKER(1);
    int rate;

    Position(int rate) {
        this.rate = rate;
    }

}
