package org.example;

import java.util.List;

public interface CarService {
    void saveCar(Car car);

    Car getById(int id);

    void delete(int id);

    List<Car> getAll();

    void updateCar(Car car);
}
