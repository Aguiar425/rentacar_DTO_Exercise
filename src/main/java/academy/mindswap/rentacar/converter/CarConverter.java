package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    public CarDto fromCarEntityToCarDto(Car car){
        return CarDto.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .pricePerDay(car.getPricePerDay())
                .build();
    }

    public Car fromCarDtoToCarEntity(CarDto carDto){
        return Car.builder()
                .model(carDto.getModel())
                .brand(carDto.getBrand())
                .pricePerDay(carDto.getPricePerDay())
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
