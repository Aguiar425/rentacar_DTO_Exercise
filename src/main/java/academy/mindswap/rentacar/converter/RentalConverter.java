package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;

public class RentalConverter {

    public RentalDto fromCarEntityToRentalDto(Rental rental){
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .users(rental.getUsers())
                .cars(rental.getCars())
                .build();
    }

    public Rental fromRentalDtoToUserEntity(RentalDto rentalDto){
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
