package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rentals")
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @ManyToMany(targetEntity = User.class)
    private List<User> users = new ArrayList<>();

    @ManyToMany(targetEntity = Car.class)
    private List<Car> cars = new ArrayList<>();
}