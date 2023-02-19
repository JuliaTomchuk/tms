package org.example.entity;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Random;

public class Horse {
    @NotBlank
    private String nameHorse;
    private int speed;

    public Horse(String nameHorse) {

        this.nameHorse = nameHorse;
        Random random = new Random();
        speed = random.nextInt(5, 50);
    }

    public String getNameHorse() {
        return nameHorse;
    }

    public void setNameHorse(String name) {
        this.nameHorse = name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse horse)) return false;
        return getSpeed() == horse.getSpeed() && getNameHorse().equals(horse.getNameHorse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameHorse(), getSpeed());
    }

    @Override
    public String toString() {
        return "Horse{" +
                "nameHorse ='" + nameHorse + '\'' +
                ", speed=" + speed +
                '}';
    }
}
