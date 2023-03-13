package academy.mindswap.rentacar.mapper;

import academy.mindswap.rentacar.dto.UserCreatedDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserDtoToUserEntity(UserDto userDto);
    UserDto fromUserCreatedDtoToUserDto(UserCreatedDto userCreatedDto);
    UserDto fromUserEntityToUserDto(User user);
    User fromUserCreatedDtoToUserEntity(UserCreatedDto userCreatedDto);
}
