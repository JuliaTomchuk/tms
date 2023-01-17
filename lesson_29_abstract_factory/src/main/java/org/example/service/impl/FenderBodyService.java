package org.example.service.impl;

import org.example.Body;
import org.example.service.BodyService;

public class FenderBodyService implements BodyService {

    @Override
    public Body createBody() {
        return new Body("Fender Body");
    }
}
