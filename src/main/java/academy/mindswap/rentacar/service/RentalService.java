package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.dto.UserCreatedDto;
import academy.mindswap.rentacar.dto.UserDto;

import java.util.List;

public interface RentalService {
    RentalDto createRental(RentalCreatedDto rentalCreatedDto);

    RentalDto getRentalById(Long rentalId);

    List<RentalDto> getAllRentals();

    RentalDto updateRental(RentalDto rentalDto);

    void deleteRental(Long rentalId);
}
