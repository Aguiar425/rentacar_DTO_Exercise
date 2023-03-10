package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarLongConverter {

    public Long carToLong(Car user){
        return user.getId();
    }

    public Car longToCar(Long carLong){
        return Car.builder()
                .id(carLong)
                .build();
    }
}
