package org.example;


import org.example.service.BodyService;
import org.example.service.KnobService;
import org.example.service.NeckService;
import org.example.service.PickupService;
import org.example.service.StringsService;
import org.example.service.TunerService;
import org.example.service.impl.FenderBodyService;
import org.example.service.impl.FenderKnobService;
import org.example.service.impl.FenderNeckService;
import org.example.service.impl.FenderPickupService;
import org.example.service.impl.FenderStringsService;
import org.example.service.impl.FenderTunerService;

public class FenderFactory implements AbstractFactory {
    @Override
    public BodyService getBodyService() {
        return new FenderBodyService();
    }

    @Override
    public KnobService getKnobService() {
        return new FenderKnobService();
    }

    @Override
    public NeckService getNeckService() {
        return new FenderNeckService();
    }

    @Override
    public PickupService getPickupService() {
        return new FenderPickupService();
    }

    @Override
    public StringsService getStringsService() {
        return new FenderStringsService();
    }

    @Override
    public TunerService getTunerService() {
        return new FenderTunerService();
    }
}
