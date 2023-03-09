package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;

import java.util.List;

public interface CarService {
    CarDto createCar(CarCreatedDto carDto);

    CarDto getCarById(Long carId);

    List<CarDto> getAllCars();

    CarDto updateCar(CarDto car);

    void deleteCar(Long carId);
}
