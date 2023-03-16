package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.service.AdminService;
import academy.mindswap.rentacar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController (AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("")
    public ResponseEntity<String> adminCheck(){

        return new ResponseEntity<>("You are an admin", HttpStatus.OK);
    }

    @PatchMapping("/makeadmin/{id}")
    public ResponseEntity<UserDto> makeAdmin(@PathVariable Long id){
        Long userId = id;
        UserDto updatedUser = adminService.makeAdmin(userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
