package org.example.service.impl;

import org.example.Pickup;
import org.example.service.PickupService;

public class GibsonPickupService implements PickupService {
    @Override
    public Pickup createPickup() {
        return new Pickup("Gibson pickup");
    }
}
