package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql = "UPDATE cars SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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

    @Column(nullable = false)
    private boolean deleted = Boolean.FALSE;

    @OneToMany (mappedBy = "car", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Rental> rentals = new ArrayList<>();

}
