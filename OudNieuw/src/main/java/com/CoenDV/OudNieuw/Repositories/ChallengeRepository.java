package com.CoenDV.OudNieuw.Repositories;

import com.CoenDV.OudNieuw.Models.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
    Challenge findChallengeByChallengeCodeAndUsedFalse(String challengeCode);
}
