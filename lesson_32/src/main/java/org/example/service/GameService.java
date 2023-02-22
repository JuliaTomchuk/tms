package org.example.service;


import org.example.entity.Result;
import org.example.service.impl.NoSuchPairException;

import java.util.List;

public interface GameService {
    Result start() throws NoSuchPairException;

}
