package org.example;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Garage {
    private Map<Integer, Car> cars;

    public Garage() {
        cars = new ConcurrentHashMap<>();
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


    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
