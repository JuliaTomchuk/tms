package org.example.entity;

import java.util.Objects;
import java.util.Random;

public class Horse {

    private String name;
    private int speed;

    public Horse(String name) {

        this.name = name;
        Random random = new Random();
        speed = random.nextInt(5, 50);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse horse)) return false;
        return getSpeed() == horse.getSpeed() && getName().equals(horse.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSpeed());
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
