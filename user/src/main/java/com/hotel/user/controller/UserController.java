package com.hotel.user.controller;

import com.hotel.user.dto.UserDTO;
import com.hotel.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
}
