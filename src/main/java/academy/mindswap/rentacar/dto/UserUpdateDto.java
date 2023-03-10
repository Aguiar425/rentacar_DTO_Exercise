package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {

    private String firstName;

    private String lastName;

    private String email;
}
