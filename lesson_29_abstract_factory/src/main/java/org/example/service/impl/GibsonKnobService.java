package org.example.service.impl;

import org.example.Knob;
import org.example.service.KnobService;

public class GibsonKnobService implements KnobService {
    @Override
    public Knob createKnobs() {
        return new Knob("Gibson knob");
    }
}
