package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.*;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    RentalDto createRental(RentalCreatedDto rentalCreatedDto);

    RentalDto getRentalById(Long rentalId);

    List<RentalDto> getAllRentals();

    RentalDto updateRental(Long rentalId, RentalUpdateDto rentalUpdateDto);

    void deleteRental(Long rentalId);
}
