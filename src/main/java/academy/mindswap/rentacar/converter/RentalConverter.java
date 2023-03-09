package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import org.springframework.stereotype.Component;

@Component
public class RentalConverter {

    public RentalDto fromRentalEntityToRentalDto(Rental rental){
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .users(rental.getUsers())
                .cars(rental.getCars())
                .build();
    }

    public Rental fromRentalDtoToRentalEntity(RentalDto rentalDto){
        return Rental.builder()
                .startDate(rentalDto.getStartDate())
                .endDate(rentalDto.getEndDate())
                .users(rentalDto.getUsers())
                .cars(rentalDto.getCars())
                .build();
    }

    public Rental fromRentalCreatedDtoToEntity(RentalCreatedDto rentalCreatedDto){
        return Rental.builder()
                .startDate(rentalCreatedDto.getStartDate())
                .endDate(rentalCreatedDto.getEndDate())
                .users(rentalCreatedDto.getUsers())
                .cars(rentalCreatedDto.getCars())
                .build();
    }
}
