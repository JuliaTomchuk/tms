package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cash {
    public static List<Car> cars = new ArrayList<>();
    private static Cash cash;

    private Cash() {
    }

    public static Cash getInstance() {
        if (cash == null) {
            synchronized (Cash.class) {
                if (cash == null) {
                    cash = new Cash();
                }
            }
        }
        return cash;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getAll() {
        return cars;
    }

    public Optional<Car> getById(int id) {
        return cars.stream().filter(c -> c.getId() == id).findAny();

    }


    public void delete(int id) {

        Optional<Car> car = cars.stream().filter(v -> v.getId() == id).findAny();
        if (car.isPresent()) {
            cars.remove(car.get());
        }
    }


    public void updateCar(Car car) {

        for (Car c : cars) {
            if (c.getId() == car.getId()) {
                c.setName(car.getName());
                c.setColor(car.getColor());
            }
        }
    }
}
