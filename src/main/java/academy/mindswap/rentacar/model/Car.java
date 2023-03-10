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
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int pricePerDay;

    @OneToMany (mappedBy = "rentals", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Rental> rentals = new ArrayList<>();

}
