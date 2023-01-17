package org.example;


import org.example.service.BodyService;
import org.example.service.KnobService;
import org.example.service.NeckService;
import org.example.service.PickupService;
import org.example.service.StringsService;
import org.example.service.TunerService;
import org.example.service.impl.GibsonBodyService;
import org.example.service.impl.GibsonKnobService;
import org.example.service.impl.GibsonNeckService;
import org.example.service.impl.GibsonPickupService;
import org.example.service.impl.GibsonStringsService;
import org.example.service.impl.GibsonTunerService;

public class GibsonFactory implements AbstractFactory {
    @Override
    public BodyService getBodyService() {
        return new GibsonBodyService();
    }

    @Override
    public KnobService getKnobService() {
        return new GibsonKnobService();
    }

    @Override
    public NeckService getNeckService() {
        return new GibsonNeckService();
    }

    @Override
    public PickupService getPickupService() {
        return new GibsonPickupService();
    }

    @Override
    public StringsService getStringsService() {
        return new GibsonStringsService();
    }

    @Override
    public TunerService getTunerService() {
        return new GibsonTunerService();
    }
}
