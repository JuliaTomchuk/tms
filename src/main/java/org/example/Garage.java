package org.example;

import java.util.HashMap;
import java.util.Map;

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

    public synchronized Car getCar(int id) {
        Car car = cars.get(id);
        if (car != null) {
            return car;
        } else {
            return new Car();
        }

    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
