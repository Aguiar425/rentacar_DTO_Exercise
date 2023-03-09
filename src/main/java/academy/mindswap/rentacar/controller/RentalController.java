package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.RentalCreatedDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RentalDto>> getAllRentals(){
        List<RentalDto> rentals = rentalService.getAllRentals();
        return new ResponseEntity<>(rentals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getRentalById(@PathVariable Long id){
        RentalDto rentalDto = rentalService.getRentalById(id);
        return new ResponseEntity<>(rentalDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalDto> createRental(@Valid @RequestBody RentalCreatedDto rentalCreatedDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors){
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RentalDto savedRental = rentalService.createRental(rentalCreatedDto);
        return new ResponseEntity<>(savedRental, HttpStatus.OK);
    }
}
