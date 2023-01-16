package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cash {
    public static List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getAll() {
        return cars;
    }

    public List<Car> getById(int id) {
        List<Car> car = new ArrayList<>();
        for (Car c : cars) {
            if (c.getId() == id) {
                car.add(c);
            }
        }
        return car;
    }

    public void delete(int id) {
        for (Car c : cars) {
            if (c.getId() == id) {
                cars.remove(c);
            }
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
