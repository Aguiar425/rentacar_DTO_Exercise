package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.RentalConverter;
import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{
    private RentalRepository rentalRepository;
    private RentalConverter rentalConverter;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository, RentalConverter rentalConverter){
        this.rentalRepository = rentalRepository;
        this.rentalConverter = rentalConverter;
    }

    @Override
    public RentalDto createRental(RentalCreatedDto rentalCreatedDto) {
    //TODO logic for cars and users

        Rental rental = rentalConverter.fromRentalCreatedDtoToEntity(rentalCreatedDto);
        rental = rentalRepository.save(rental);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public RentalDto getRentalById(Long rentalId) {
        Rental rental = rentalRepository.getReferenceById(rentalId);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public List<RentalDto> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        List<RentalDto> rentalDtos = rentals.stream()
                .map(rentalConverter::fromRentalEntityToRentalDto)
                .toList();
        return rentalDtos;
    }

    @Override
    public RentalDto updateRental(RentalDto rentalDto, String newStartDate, String newEndDate, List<User> newUsers, List<Car> newCars) {
        Rental updateRental = rentalConverter.fromRentalDtoToRentalEntity(rentalDto);
        if(newStartDate.equals(null)){
            updateRental.setStartDate(rentalDto.getStartDate());
        } else {
            updateRental.setStartDate(newStartDate);
        }

        if(newEndDate.equals(null)){
            updateRental.setEndDate(rentalDto.getEndDate());
        } else {
            updateRental.setEndDate(newEndDate);
        }

        if(newUsers.equals(null)){
            updateRental.setUsers(rentalDto.getUsers());
        } else {
            updateRental.setUsers(newUsers);
        }

        if(newCars.equals(null)){
            updateRental.setCars(rentalDto.getCars());
        } else {
            updateRental.setCars(newCars);
        }

        RentalDto updatedRentalDto = rentalConverter.fromRentalEntityToRentalDto(updateRental);
        return updatedRentalDto;
    }

    @Override
    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}
