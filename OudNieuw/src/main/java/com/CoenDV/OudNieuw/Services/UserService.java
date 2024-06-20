package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(String username) {
        return userRepository.findByUsername(username);
    }
}
