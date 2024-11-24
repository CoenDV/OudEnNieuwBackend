package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.DTO.AddPointsRequest;
import com.CoenDV.OudNieuw.Models.DTO.GetPointsReply;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    private SimpMessagingTemplate template;
    ObjectMapper objectMapper = new ObjectMapper();

    public UserService(UserRepository userRepository, SimpMessagingTemplate template, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.template = template;
        this.objectMapper = objectMapper;
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

    public User addPoints(AddPointsRequest request) throws JsonProcessingException {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent()) {
            User u = user.get();
            u.setPoints(u.getPoints() + request.getPoints());
            u.setTotalPoints(u.getTotalPoints() + request.getPoints());
            userRepository.save(u);
            template.convertAndSend("/topic/quiz-mainscreen", objectMapper.writeValueAsString("update points"));
            return u;
        }
        return null;
    }

    public void addCorrectAnswerCount(int id) {
        User u = userRepository.findById(id).get();
        u.setCorrectAnswers(u.getCorrectAnswers() + 1);
        userRepository.save(u);
    }

    public GetPointsReply getPoints(String username) {
        return new GetPointsReply(
                userRepository.findByUsername(username).get().getPoints(),
                userRepository.findAll().stream().filter(u -> u.getPoints() > userRepository.findByUsername(username).get().getPoints()).toArray().length + 1
        );
    }
}
