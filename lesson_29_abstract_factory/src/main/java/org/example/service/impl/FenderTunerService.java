package org.example.service.impl;

import org.example.Tuner;
import org.example.service.TunerService;

public class FenderTunerService implements TunerService {
    @Override
    public Tuner createTuner() {
        return new Tuner("Fender tuner");
    }
}
