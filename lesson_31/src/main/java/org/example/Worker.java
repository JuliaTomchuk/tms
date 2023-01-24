package org.example;

public class Worker extends Employee {


    public Worker() {
        position = Position.WORKER;
    }

    public Worker(String name, String surname, int experience) {
        super(name, surname, experience);
        position=Position.WORKER;

    }



}
