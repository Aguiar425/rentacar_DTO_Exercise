package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDto>> getAllCars(){
        List<CarDto> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id){
        CarDto carDto = carService.getCarById(id);
        return new ResponseEntity<>(carDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarCreatedDto carCreatedDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors){
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CarDto savedCar = carService.createCar(carCreatedDto);
        return new ResponseEntity<>(savedCar, HttpStatus.OK);
    }

    @PutMapping
    @Modifying
    @Query("UPDATE cars c SET brand = newBrand, model = newModel, price = newPrice WHERE id = targetId")
    public ResponseEntity<CarDto> updateCar(@Param("targetId") Long carId, @Param("newBrand") String newBrand,
                                            @Param("newModel") String  newModel, @Param("newPrice") int newPrice){
        CarDto carDtoUpdate = carService.getCarById(carId);
        carDtoUpdate = carService.updateCar(carDtoUpdate, newBrand, newModel, newPrice);
        return new ResponseEntity<>(carDtoUpdate, HttpStatus.OK);
    }
}
