package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.mapper.UserMapper;
import academy.mindswap.rentacar.model.Role;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.CarRepository;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminServiceImpl implements AdminService{

    private UserRepository userRepository;
    private CarRepository carRepository;
    UserMapper userMapper;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, CarRepository carRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto makeAdmin(Long userId) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with ID: " + userId));

        userToUpdate.setRole(Role.ADMIN);
        User newAdminUser = userRepository.save(userToUpdate);
        return userMapper.fromUserEntityToUserDto(newAdminUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);

    }
}
