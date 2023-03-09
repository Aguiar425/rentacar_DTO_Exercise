package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.UserConverter;
import academy.mindswap.rentacar.dto.UserCreatedDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter){
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }


    @Override
    public UserDto createUser(UserCreatedDto userCreatedDto) {
        if(!userCreatedDto.getPassword().equals(userCreatedDto.getRetypedPassword())){
            throw new IllegalArgumentException("Passwords do not match");
        }
        User user = userConverter.fromUserCreatedDtoToEntity(userCreatedDto);
        user = userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        //Optional<User> user = userRepository.findById(userId);
        //return userConverter.fromUserEntityToUserDto(user);
        User user = userRepository.getReferenceById(userId);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream()
                .map(userConverter::fromUserEntityToUserDto)
                .toList();
        return userDtos;
        /*return userRepository.findAll().stream()
                .map(userConverter::fromUserEntityToUserDto)
                .toList();*/
    }

    @Override
    public UserDto updateUser(UserDto userDto, String newFirstName, String newLastName, String newEmail) {

        User updatedUser = userConverter.fromUserDtoToUserEntity(userDto);
        if(newFirstName.equals(null)){
            updatedUser.setFirstName(userDto.getFirstName());
        } else {
            updatedUser.setFirstName(newFirstName);
        }

        if(newLastName.equals(null)){
            updatedUser.setLastName(userDto.getLastName());
        } else {
            updatedUser.setLastName(newLastName);
        }

        if(newEmail.equals(null)){
            updatedUser.setEmail(userDto.getEmail());
        } else {
            updatedUser.setEmail(newEmail);
        }

        UserDto updatedUserDto = userConverter.fromUserEntityToUserDto(updatedUser);
        return updatedUserDto;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
