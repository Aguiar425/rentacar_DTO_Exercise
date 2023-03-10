package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    @ManyToMany(targetEntity = Car.class, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();
}