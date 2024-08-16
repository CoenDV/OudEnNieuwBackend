package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.DTO.AddPointsRequest;
import com.CoenDV.OudNieuw.Models.DTO.GetPointsReply;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.sort((u1, u2) -> u2.getPoints() - u1.getPoints());
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User addPoints(AddPointsRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent()) {
            User u = user.get();
            u.setPoints(u.getPoints() + request.getPoints());
            userRepository.save(u);
            return u;
        }
        return null;
    }

    public GetPointsReply getPoints(String username) {
        return new GetPointsReply(
                userRepository.findByUsername(username).get().getPoints(),
                userRepository.findAll().stream().filter(u -> u.getPoints() > userRepository.findByUsername(username).get().getPoints()).toArray().length + 1
        );
    }
}
