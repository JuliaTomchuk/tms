package org.example.entity;


import java.util.Objects;


public class Pair {

    private Horse horse;

    private Rider rider;

    private int pairSpeed;


    public Pair(Horse horse, Rider rider) {

        this.horse = horse;
        this.rider = rider;

        pairSpeed = horse.getSpeed() + rider.getExperience();

    }

    public void setPairSpeed(int pairSpeed) {
        this.pairSpeed = pairSpeed;
    }

    public int getPairSpeed() {
        return pairSpeed;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair pair)) return false;
        return getPairSpeed() == pair.getPairSpeed() && getHorse().equals(pair.getHorse()) && getRider().equals(pair.getRider());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorse(), getRider(), getPairSpeed());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "horse=" + horse +
                ", rider=" + rider +
                ", pairSpeed=" + pairSpeed +
                '}';
    }
}

