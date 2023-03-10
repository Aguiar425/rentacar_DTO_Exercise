package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalConverter {
    @Autowired
    UserLongConverter userLongConverter;
    @Autowired
    CarLongConverter carLongConverter;

    public RentalDto fromRentalEntityToRentalDto(Rental rental){
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .user(rental.getUser().getFirstName() + " ".concat(rental.getUser().getLastName()))
                .car(rental.getCar().getBrand() + " ".concat(rental.getCar().getModel()))
                .build();
    }

//    public Rental fromRentalDtoToRentalEntity(RentalDto rentalDto){
//        return Rental.builder()
//                .startDate(rentalDto.getStartDate())
//                .endDate(rentalDto.getEndDate())
//                .user(rentalDto.getUser())
//                .car(rentalDto.getCar())
//                .build();
//    }

    public Rental fromRentalCreatedDtoToEntity(RentalCreatedDto rentalCreatedDto){
        return Rental.builder()
                .startDate(rentalCreatedDto.getStartDate())
                .endDate(rentalCreatedDto.getEndDate())
                .user(userLongConverter.longToUser(rentalCreatedDto.getUser()))
                .car(carLongConverter.longToCar(rentalCreatedDto.getCar()))
                .build();
    }
}
