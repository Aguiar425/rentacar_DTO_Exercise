package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarListConverter {

    private CarConverter carConverter;

    public List<CarDto> fromEntityListToDtoList(List<Car> carsList){
        List<CarDto> carDtos = new ArrayList<>();
        for (Car cars :
                carsList) {
            carDtos.add(carConverter.fromCarEntityToCarDto(cars));
        }
        return carDtos;
    }

    public List<Car> fromDtoListToEntityList(List<CarDto> dtoList){
        List<Car> carList = new ArrayList<>();
        for (CarDto carDto :
                dtoList) {
            carList.add(carConverter.fromCarDtoToCarEntity(carDto));
        }
        return carList;
    }
}
