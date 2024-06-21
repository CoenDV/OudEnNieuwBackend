package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.Challenge;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.ChallengeRepository;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChallengeService {

    ChallengeRepository challengeRepository;
    UserRepository userRepository;

    public ChallengeService(ChallengeRepository challengeRepository, UserRepository userRepository) {
        this.challengeRepository = challengeRepository;
        this.userRepository = userRepository;
    }

    public Challenge getChallenge(String challengeCode, int userId) {
        Challenge challenge = challengeRepository.findChallengeByChallengeCodeAndUsedFalse(challengeCode);
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setActiveChallenge(challenge);
            userRepository.save(user.get());

            challenge.setUsed(true);
            challengeRepository.save(challenge);
        }

        return challenge;
    }

    public void deleteChallenge(int userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setActiveChallenge(null);
            userRepository.save(user.get());
        }
    }
}
