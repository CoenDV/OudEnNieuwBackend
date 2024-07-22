package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.Challenge;
import com.CoenDV.OudNieuw.Services.ChallengeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("challenge")
@CrossOrigin(origins = {"http://localhost:5173/", "https://oudennieuw.onrender.com/"})
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/{challengeCode}/{userId}")
    public Challenge getChallenge(@PathVariable String challengeCode, @PathVariable int userId) {
        return challengeService.getChallenge(challengeCode, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteChallenge(@PathVariable int userId) {
        challengeService.deleteChallenge(userId);
    }
}
