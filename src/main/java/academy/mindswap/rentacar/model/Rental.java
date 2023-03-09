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

    @OneToMany(mappedBy = "rentals", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "rentals", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();
}