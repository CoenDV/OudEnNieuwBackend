package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.DTO.AddPointsRequest;
import com.CoenDV.OudNieuw.Models.DTO.GetPointsReply;
import com.CoenDV.OudNieuw.Models.DTO.LoginRequestDTO;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/", "https://oudennieuw.onrender.com/", "https://oud-en-nieuw-backend-git-coen-de-vries-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/"})
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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}/points")
    public GetPointsReply getPoints(@PathVariable String username) {
        System.out.println();
        return userService.getPoints(username);
    }

    @PutMapping
    public User addPoints(@RequestBody AddPointsRequest request) {
        return userService.addPoints(request);
    }
}
