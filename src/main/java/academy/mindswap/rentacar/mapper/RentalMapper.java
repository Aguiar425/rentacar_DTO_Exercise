package academy.mindswap.rentacar.mapper;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Rental;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    RentalDto fromRentalEntityToRentalDto(Rental rental);
    Rental fromRentalCreatedDtoToRentalEntity(RentalCreatedDto rentalCreatedDto);

}
