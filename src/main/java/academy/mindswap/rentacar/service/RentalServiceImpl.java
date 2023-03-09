package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{
    @Override
    public RentalDto createRental(RentalCreatedDto rentalCreatedDto) {
        return null;
    }

    @Override
    public RentalDto getRentalById(Long rentalId) {
        return null;
    }

    @Override
    public List<RentalDto> getAllRentals() {
        return null;
    }

    @Override
    public RentalDto updateRental(RentalDto rentalDto) {
        return null;
    }

    @Override
    public void deleteRental(Long rentalId) {

    }
}
