package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    @NotBlank(message = "Must have brand")
    private String brand;

    @NotBlank(message = "Must have model")
    private String model;

    @NotBlank(message = "Must have a price")
    private int pricePerDay;
}
