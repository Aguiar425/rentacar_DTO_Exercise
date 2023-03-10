package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarUpdateDto {

    private String brand;

    private String model;

    private int pricePerDay;
}
