package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
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
    public CarDto updateCar(CarDto carDto, String newBrand, String newModel, int newPrice) {

        Car updatedCar = carConverter.fromCarDtoToCarEntity(carDto);
        if(newBrand.equals(null)){
            updatedCar.setBrand(carDto.getBrand());
        } else {
            updatedCar.setBrand(newBrand);
        }

        if(newModel.equals(null)){
            updatedCar.setModel(carDto.getModel());
        } else {
            updatedCar.setModel(newModel);
        }

        if(newPrice <= 0){
            updatedCar.setPricePerDay(carDto.getPricePerDay());
        } else {
            updatedCar.setPricePerDay(newPrice);
        }

        CarDto updatedCarDto = carConverter.fromCarEntityToCarDto(updatedCar);
        return updatedCarDto;
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
