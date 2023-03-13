package academy.mindswap.rentacar.mapper;


import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto carEntityToCarDto(Car car);
    CarDto carCreatedDtoToCarDto(CarCreatedDto carCreatedDto);
    Car carDtoToCarEntity(CarDto carDto);
    Car carCreatedDtoToCarEntity(CarCreatedDto carCreatedDto);

/*    @Mapping(target = "brand", source = "entity.brand")
    @Mapping(target = "model", source = "entity.model")
    @Mapping(target = "pricePerDay", source = "entity.pricePerDay")
    CarDto carEntityToCarDto(Car entity);

    @Mapping(target = "brand", source = "dto.brand")
    @Mapping(target = "model", source = "dto.model")
    @Mapping(target = "pricePerDay", source = "dto.pricePerDay")
    Car carDtoToCarEntity (CarDto dto);*/

}
