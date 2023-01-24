package org.example;

public class Main {
    public static void main(String[] args)  {
       Book book = new Book("War and Peace","Leo Tolstoy",999);
       Book book1;
        try {
           book1= (Book)book.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(book);
        System.out.println(book1);
    }
}