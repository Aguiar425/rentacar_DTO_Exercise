package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserLongConverter {

    public Long userToLong(User user){
        return user.getId();
    }

    public User longToUser(Long userlong){
        return User.builder()
                .id(userlong)
                .build();
    }
}
