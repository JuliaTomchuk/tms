package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CacheCarService implements CarService {

    public static final List<Car> cache = new ArrayList<>();

    private CarService carService;

    public CacheCarService(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void saveCar(Car car) {
        carService.saveCar(car);
        cache.add(car);
    }

    @Override
    public Car getById(int id) {

        Car car = cache.stream().filter(c -> c.getId() == id).findFirst().orElse(new Car());
        if (car.getId()!=0) {
            return car;
        } else {
            Car car1 = carService.getById(id);
            cache.add(car1);
            return car1;
        }
    }

    @Override
    public void delete(int id) {
        carService.delete(id);
        Optional<Car> car = cache.stream().filter(c -> c.getId() == id).findFirst();
        if (car.isPresent()) {
            cache.remove(car);
        }

    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = carService.getAll();
        return cars;
    }

    @Override
    public void updateCar(Car car) {
        carService.updateCar(car);
        Optional<Car> carCache = cache.stream().filter(c -> c.getId() == car.getId()).findFirst();
        if (carCache.isPresent()) {
            cache.remove(carCache);
            }

    }


}
