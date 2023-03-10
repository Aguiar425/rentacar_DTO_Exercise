package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.CarUpdateDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = cars.stream()
                .map(carConverter::fromCarEntityToCarDto)
                .toList();
        return carDtos;
    }

    @Override
    public CarDto updateCar(Long carId, CarUpdateDto carUpdateDto) {
        Car carToUpdate = carRepository.findById(carId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No car found with ID: " + carId));

        if(carUpdateDto.getBrand() != null){
            carToUpdate.setBrand(carUpdateDto.getBrand());
        }

        if(carUpdateDto.getModel() != null){
            carToUpdate.setModel(carUpdateDto.getModel());
        }

        if(carUpdateDto.getPricePerDay() <= 0){
            carToUpdate.setPricePerDay(carUpdateDto.getPricePerDay());
        }

        Car updatedCar = carRepository.save(carToUpdate);
        CarDto updatedCarDto = carConverter.fromCarEntityToCarDto(updatedCar);
        return updatedCarDto;
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
