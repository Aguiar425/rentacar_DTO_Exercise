package academy.mindswap.rentacar.dto;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

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
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column
    private List<User> users = new ArrayList<>();

    @Column
    private List<Car> cars = new ArrayList<>();
}
