package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    @Autowired
    public AdminController (UserService userService){
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<String> adminCheck(){

        return new ResponseEntity<>("You are an admin", HttpStatus.OK);
    }
    @PatchMapping("/makeadmin/{id}")
    public ResponseEntity<UserDto> makeAdmin(@PathVariable Long id){
        Long userId = id;
        UserDto updatedUser = userService.makeAdmin(userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
