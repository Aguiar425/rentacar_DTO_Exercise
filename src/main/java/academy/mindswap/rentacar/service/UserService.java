package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserCreatedDto;
import academy.mindswap.rentacar.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserCreatedDto userCreatedDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto, String newFirstName, String newLastName, String newEmail);

    void deleteUser(Long userId);
}
