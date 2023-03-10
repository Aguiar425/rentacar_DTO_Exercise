package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.*;
import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.dto.RentalUpdateDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;
    private RentalConverter rentalConverter;


    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository, RentalConverter rentalConverter) {
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
    public RentalDto updateRental(Long rentalId, RentalUpdateDto rentalUpdateDto) {
        Rental rentalToUpdate = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No rental found with ID: " + rentalId));

        if (rentalUpdateDto.getStartDate() != null) {
            rentalToUpdate.setStartDate(rentalUpdateDto.getStartDate());
        }

        if (rentalUpdateDto.getEndDate() != null) {
            rentalToUpdate.setEndDate(rentalUpdateDto.getEndDate());
        }

        if (rentalUpdateDto.getUser() != null) {
            rentalToUpdate.setUser(rentalUpdateDto.getUser());
        }

        if (rentalUpdateDto.getCar() != null) {
            rentalToUpdate.setCar(rentalUpdateDto.getCar());
        }

        Rental updatedRental = rentalRepository.save(rentalToUpdate);
        RentalDto updatedRentalDto = rentalConverter.fromRentalEntityToRentalDto(updatedRental);
        return updatedRentalDto;
    }

    @Override
    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}

