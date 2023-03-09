package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;
    private CarConverter carConverter;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter){
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    @Override
    public CarDto createCar(CarCreatedDto carCreatedDto) {
        Car savedCar = carConverter.fromCarCreatedDtoToEntity(carCreatedDto);
        savedCar = carRepository.save(savedCar);
        return carConverter.fromCarEntityToCarDto(savedCar);
    }

    @Override
    public CarDto getCarById(Long carId) {
        Car car = carRepository.getReferenceById(carId);
        return carConverter.fr;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public void deleteCar(Long carId) {

    }
}
