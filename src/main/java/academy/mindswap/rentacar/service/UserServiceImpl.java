package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.UserCreatedDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.dto.UserUpdateDto;
import academy.mindswap.rentacar.exceptions.CarNotFoundException;
import academy.mindswap.rentacar.exceptions.UserNotFoundException;
import academy.mindswap.rentacar.mapper.UserMapper;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Role;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(userMapper::fromUserEntityToUserDto).orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream()
                .map(userMapper::fromUserEntityToUserDto)
                .toList();
        return userDtos;
    }

    @Override
    public UserDto updateUser(Long userId, UserUpdateDto userUpdateDto) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with ID: " + userId));

        if (userUpdateDto.getFirstName() != null) {
            userToUpdate.setFirstName(userUpdateDto.getFirstName());
        }

        if (userUpdateDto.getLastName() != null) {
            userToUpdate.setLastName(userUpdateDto.getLastName());
        }

        if (userUpdateDto.getEmail() != null) {
            userToUpdate.setEmail(userUpdateDto.getEmail());
        }

        User updatedUser = userRepository.save(userToUpdate);
        UserDto updatedUserDto = userMapper.fromUserEntityToUserDto(updatedUser);
        return updatedUserDto;
    }
}
