package org.example;

public class Main {
    public static void main(String[] args) {

        Country norway = new Country.CountryBuilder()
                .setArea(385.207)
                .setCapital("Oslo")
                .setMainCities(new String[]{"Oslo", "Bergen", "Stavanger", "Trondheim"})
                .setCurrency("Norwegian Krone")
                .setName("Norway")
                .setLanguages(new String[]{"Norwegian"})
                .setPopulation(5_528_298)
                .setReligions(new String[]{"Lutheran Christianity", "The Catholic Church"})
                .build();

        System.out.println(norway);
    }
}