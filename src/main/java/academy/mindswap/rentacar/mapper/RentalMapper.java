package academy.mindswap.rentacar.mapper;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.service.CarServiceImpl;
import academy.mindswap.rentacar.service.UserServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface RentalMapper {
//    CarServiceImpl carService;
//    UserServiceImpl userService;


    //RentalDto fromRentalEntityToRentalDto(Rental rental);
    Rental fromRentalCreatedDtoToRentalEntity(RentalCreatedDto rentalCreatedDto);

    default RentalDto fromRentalEntityToRentalDto(Rental rental) {
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .user(rental.getUser().getFirstName() + " ".concat(rental.getUser().getLastName()))
                .car(rental.getCar().getBrand() + " ".concat(rental.getCar().getModel()))
                .build();
    }
    default Rental fromRentalCreatedDtoToRentalEntityTESTE(RentalCreatedDto rentalCreatedDto){
        if ( rentalCreatedDto == null ) {
            return null;
        }

//        carService.getCarById(rentalCreatedDto.getCar().getId());
//        userService.getUserById(rentalCreatedDto.getUser().getId());
        Rental.RentalBuilder rental = Rental.builder();

        rental.startDate( rentalCreatedDto.getStartDate() );
        rental.endDate( rentalCreatedDto.getEndDate() );
        rental.user( rentalCreatedDto.getUser() );
        rental.car( rentalCreatedDto.getCar() );

        return rental.build();
    }
}
