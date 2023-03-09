package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.model.Car;

import java.util.List;

public interface CarService {
    Car createCar(Car car);

    Car getCarById(Long carId);

    List<Car> getAllCars();

    Car updateCar(Car car);

    void deleteCar(Long carId);
}
