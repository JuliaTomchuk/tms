package org.example.service.impl;

import org.example.Knob;
import org.example.service.KnobService;

public class FenderKnobService implements KnobService {
    @Override
    public Knob createKnobs() {
        return new Knob("Fender knob");
    }
}
