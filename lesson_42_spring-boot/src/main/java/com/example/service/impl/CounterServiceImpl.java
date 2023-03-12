package com.example.service.impl;

import com.example.service.CounterService;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class CounterServiceImpl implements CounterService {
    @Value("${filePath}")
    private String filePath;

    @PostConstruct
    @Override
    public void add() throws IOException {
        Path path = Path.of(filePath);
        if (Files.exists(path)) {
            Optional<Integer> counterOptional = Files.lines(path).map(Integer::parseInt).findFirst();
            int counter = counterOptional.get() + 1;
            String counterStr = String.valueOf(counter);
            Files.write(path, counterStr.getBytes());
        } else {
            Files.createFile(path);
            Files.write(path, "1".getBytes());
        }
    }
}
