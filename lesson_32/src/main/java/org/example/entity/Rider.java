package org.example.entity;


import java.util.Random;

public class Rider {

    private String name;
    private int experience;

    public Rider(String name) {
        Random random = new Random();
        experience = random.nextInt(1, 15);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
