package org.example;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Map<Integer,Car> cars;
    public Garage(){
        cars = new HashMap<>();
    }
    public Garage(HashMap<Integer,Car> cars){
        this.cars = cars;
    }

    public Map<Integer, Car> getCars() {
        return cars;
    }

    public void setCars(Map<Integer, Car> cars) {
        this.cars = cars;
    }
    public void setCar(Car car){
        cars.put(car.getId(),car);
    }
    public Car getCar(int id){
        return cars.get(id);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
