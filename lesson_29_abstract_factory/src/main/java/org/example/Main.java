package org.example;

public class Main {
    public static void main(String[] args) {
        MainService mainService = new MainService();
        String type ="fender";
        if(type.equals("gibson")){

            mainService.createGuitar(new GibsonFactory());
        }else if(type.equals("fender")){
            mainService.createGuitar(new FenderFactory());
        }

    }
}