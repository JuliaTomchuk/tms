package org.example.service.impl;

import org.example.Strings;
import org.example.service.StringsService;

public class GibsonStringsService implements StringsService {
    @Override
    public Strings createStrings() {
        return new Strings("Gibson strings");
    }
}
