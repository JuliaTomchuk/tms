package org.example;


import lombok.ToString;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
@ToString
public class Garage {
    private Map<Integer, Car> cars = new ConcurrentHashMap<>();
    private static Garage garage;

    private Garage() {

    }

    public static Garage getInstance() {
        if (garage == null) {
            synchronized (Garage.class) {
                if (garage == null) {
                    garage = new Garage();
                }
            }
        }
        return garage;
    }

    public Map<Integer, Car> getCars() {
        return cars;
    }

    public void setCars(Map<Integer, Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (car != null && car.getName() != null) {
            cars.put(car.getId(), car);
        }
    }

    public Optional<Car> getCar(int id) {

        return Optional.ofNullable(cars.get(id));


    }

    public void deleteCar(int id) {

        cars.remove(id);
    }



}
