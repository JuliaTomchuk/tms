package org.example;

public class Main {
    public static void main(String[] args) {
        User ann = new User("Ann");
        User john = new User("John");

        Chat chat = new Chat();

        String messageAnn = ann.getMessage();
        String messageJohn = john.getMessage();
        System.out.println(messageAnn);
        System.out.println(messageJohn);

        chat.addListener(ann);
        chat.addListener(john);

        chat.setMessage("sale");

        messageAnn = ann.getMessage();
        messageJohn = john.getMessage();
        System.out.println(messageAnn);
        System.out.println(messageJohn);

    }
}