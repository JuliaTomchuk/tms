package org.example;

public class MainService {

    public void createGuitar(AbstractFactory factory){
        Body body = factory.getBodyService().createBody();
        System.out.println(body);
        Knob knob= factory.getKnobService().createKnobs();
        System.out.println(knob);
        Neck neck = factory.getNeckService().createNeck();
        System.out.println(neck);
        Pickup pickup = factory.getPickupService().createPickup();
        System.out.println(pickup);
        Strings strings = factory.getStringsService().createStrings();
        System.out.println(strings);
        Tuner tuner = factory.getTunerService().createTuner();
        System.out.println(tuner);
    }
}
