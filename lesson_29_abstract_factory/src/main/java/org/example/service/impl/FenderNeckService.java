package org.example.service.impl;

import org.example.Neck;
import org.example.service.NeckService;

public class FenderNeckService implements NeckService {
    @Override
    public Neck createNeck() {
        return new Neck("Fender neck");
    }
}
