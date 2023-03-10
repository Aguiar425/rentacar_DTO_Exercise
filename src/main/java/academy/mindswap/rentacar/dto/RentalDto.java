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
public class RentalDto {

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column
    private String user;

    @Column
    private String car;
}
