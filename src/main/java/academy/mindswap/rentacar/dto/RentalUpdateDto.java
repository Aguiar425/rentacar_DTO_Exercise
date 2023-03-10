package academy.mindswap.rentacar.dto;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalUpdateDto {

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private List<User> users = new ArrayList<>();

    @Column
    private List<Car> cars = new ArrayList<>();
}
