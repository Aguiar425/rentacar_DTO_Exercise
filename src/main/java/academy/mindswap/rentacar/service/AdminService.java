package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.*;


public interface AdminService  {

    public UserDto makeAdmin(Long userId);

    public void deleteUser(Long userId);
    public void deleteCar(Long carId);

}

