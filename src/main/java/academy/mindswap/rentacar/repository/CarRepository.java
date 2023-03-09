package academy.mindswap.rentacar.repository;

import academy.mindswap.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
