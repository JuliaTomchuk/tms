package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Garage {
    private Map<Integer, Car> cars;

    public Garage() {
        cars = new HashMap<>();
    }


    public synchronized Map<Integer, Car> getCars() {
        return cars;
    }

    public synchronized void setCars(Map<Integer, Car> cars) {
        this.cars = cars;
    }

    public synchronized void addCar(Car car) {
        if (car != null && car.getName() != null) {
            cars.put(car.getId(), car);
        }
    }

    public synchronized Optional<Car> getCar(int id) {
        Optional<Car> car = Optional.of(cars.get(id));

        return car;


    }

    public synchronized void deleteCar(int id) {
        cars.remove(id);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
