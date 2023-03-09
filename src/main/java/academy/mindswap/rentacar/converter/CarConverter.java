package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;

public class CarConverter {
    public CarDto fromCarEntityToCarDto(Car car){
        return CarDto.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .pricePerDay(car.getPricePerDay())
                .build();
    }

    public Car fromCarDtoToUserEntity(Car car){
        return Car.builder()
                .model(car.getModel())
                .brand(car.getBrand())
                .pricePerDay(car.getPricePerDay())
                .build();
    }

    public Car fromCarCreatedDtoToEntity(CarCreatedDto carCreatedDto){
        return Car.builder()
                .brand(carCreatedDto.getBrand())
                .model(carCreatedDto.getModel())
                .pricePerDay(carCreatedDto.getPricePerDay())
                .build();
    }
}
