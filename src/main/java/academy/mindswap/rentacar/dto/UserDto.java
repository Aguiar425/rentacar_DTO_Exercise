package academy.mindswap.rentacar.dto;

import academy.mindswap.rentacar.model.Rental;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "Must have first name")
    private String firstName;

    @NotBlank(message = "Must have last name")
    private String lastName;

    @NotBlank(message = "Must have email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
    private String email;

    private List<Rental> rentals = new ArrayList<>();

/*    @Min(value = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Must have a role")
    private String role;*/
}
