package academy.mindswap.rentacar.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedDto {

    @NotBlank(message = "Must have a first name")
    private String firstName;

    @NotBlank(message = "Must have a last name")
    private String lastName;

    @NotBlank(message = "Must have email")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    @NotNull(message = "Must have a password")
    private String password;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    @NotNull(message = "Must have a password")
    private String retypedPassword;

    @NotBlank(message = "Must have a role")
    private String role;
}
