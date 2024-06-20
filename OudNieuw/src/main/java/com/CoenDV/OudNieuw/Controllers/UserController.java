package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.LoginRequestDTO;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("login")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Optional<User> login(@RequestBody LoginRequestDTO username) {
        return userService.login(username.getUsername());
    }
}
