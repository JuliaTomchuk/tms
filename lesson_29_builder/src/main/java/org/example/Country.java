package org.example;

import java.util.Arrays;

public class Country {
    private String name;
    private String capital;
    private double area;
    private String currency;
    private double population;
    private String[] religions;
    private String[] languages;
    private String[] mainCities;

    public Country(String name, String capital, double area, String currency, double population, String[] religions, String[] languages, String[] mainCities) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.currency = currency;
        this.population = population;
        this.religions = religions;
        this.languages = languages;
        this.mainCities = mainCities;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String[] getReligions() {
        return religions;
    }

    public void setReligions(String[] religions) {
        this.religions = religions;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getMainCities() {
        return mainCities;
    }

    public void setManinCities(String[] mainCities) {
        this.mainCities = mainCities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", area=" + area +
                ", currency='" + currency + '\'' +
                ", population=" + population +
                ", religions=" + Arrays.toString(religions) +
                ", languages=" + Arrays.toString(languages) +
                ", mainCities='" + Arrays.toString(mainCities) + '\'' +
                '}';
    }

    public static class CountryBuilder {
        private String name;
        private String capital;
        private double area;
        private String currency;
        private double population;
        private String[] religions;
        private String[] languages;
        private String[] mainCities;

        public CountryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CountryBuilder setCapital(String capital) {
            this.capital = capital;
            return this;
        }

        public CountryBuilder setArea(double area) {
            this.area = area;
            return this;
        }

        public CountryBuilder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public CountryBuilder setPopulation(double population) {
            this.population = population;
            return this;
        }

        public CountryBuilder setReligions(String[] religions) {
            this.religions = religions;
            return this;
        }

        public CountryBuilder setLanguages(String[] languages) {
            this.languages = languages;
            return this;
        }

        public CountryBuilder setMainCities(String[] mainCities) {
            this.mainCities = mainCities;
            return this;
        }

        public Country build() {
            return new Country(name, capital, area, currency, population, religions, languages, mainCities);
        }
    }
}
