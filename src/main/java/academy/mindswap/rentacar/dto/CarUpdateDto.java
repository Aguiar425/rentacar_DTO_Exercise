package academy.mindswap.rentacar.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarUpdateDto {

    private String brand;

    private String model;

    private int pricePerDay;
}
