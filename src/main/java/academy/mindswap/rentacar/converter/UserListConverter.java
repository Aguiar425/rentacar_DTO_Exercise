package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserListConverter {

    @Autowired
    private UserConverter userConverter;

    public List<UserDto> fromEntityListToDtoList(List<User> userList) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user :
                userList) {
            userDtos.add(userConverter.fromUserEntityToUserDto(user));
        }
        return userDtos;
    }

    public List<User> fromDtoListToEntityList(List<UserDto> dtoList) {
        List<User> userList = new ArrayList<>();
        for (UserDto userDto :
                dtoList) {
            userList.add(userConverter.fromUserDtoToUserEntity(userDto));
        }
        return userList;
    }
}
