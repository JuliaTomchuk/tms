package org.example;

public class Main {
    public static void main(String[] args) {

        Command save = new Save();
        Command update = new Update();

        Service service = new Service();
        service.doAction(save);

    }
}