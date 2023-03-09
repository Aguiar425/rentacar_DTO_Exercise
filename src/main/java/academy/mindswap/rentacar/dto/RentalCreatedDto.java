package academy.mindswap.rentacar.dto;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

public class RentalCreatedDto {

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column
    private List<User> users = new ArrayList<>();

    @Column
    private List<Car> cars = new ArrayList<>();
}
