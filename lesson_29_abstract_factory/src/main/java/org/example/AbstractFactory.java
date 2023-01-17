package org.example;

import org.example.service.*;

interface  AbstractFactory {

    BodyService getBodyService();
    KnobService getKnobService();
    NeckService getNeckService();
    PickupService getPickupService();
    StringsService getStringsService();
    TunerService getTunerService();
}
