package com.CoenDV.OudNieuw.Config;

import com.CoenDV.OudNieuw.Models.Challenge;
import com.CoenDV.OudNieuw.Models.Enums.Role;
import com.CoenDV.OudNieuw.Models.Quiz;
import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.ChallengeRepository;
import com.CoenDV.OudNieuw.Repositories.QuizRepository;
import com.CoenDV.OudNieuw.Repositories.ShopRepository;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class DataSeeder implements ApplicationRunner {

    UserRepository userRepository;
    QuizRepository quizRepository;
    ShopRepository shopRepository;
    ChallengeRepository challengeRepository;

    public DataSeeder(UserRepository userRepository, QuizRepository quizRepository, ShopRepository shopRepository, ChallengeRepository challengeRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.shopRepository = shopRepository;
        this.challengeRepository = challengeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // USERS
        List<User> users = List.of(
                new User(1, "Melvin", Role.ROLE_USER, 0, null),
                new User(2, "Jeffrey", Role.ROLE_USER, 0, null),
                new User(3, "Daniel", Role.ROLE_USER, 0, null),
                new User(4, "Bjorn", Role.ROLE_USER, 0, null),
                new User(5, "Quinty", Role.ROLE_USER, 0, null),
                new User(6, "Femke", Role.ROLE_USER, 0, null)
        );

        userRepository.saveAll(users);

        int pointsForRondjeShotjes = (users.size() - 1) * 100;

        // SHOP ITEMS
        List<ShopItem> shopItems = List.of(
                new ShopItem(1, "Shotje 20", "Deel 1 shotje van min 20% uit", 100),
                new ShopItem(2, "Steen Papier Schaar", "Best of 3 verlierzer neemt een shotje van min 20%", 80),
                new ShopItem(3, "Rondje Shotjes", "Deel 1 shotje van minimaal 20% uit", pointsForRondjeShotjes),
                new ShopItem(4, "Snake Eyes", "Activeer snake eyes voor jezelf, 15min", 100),
                new ShopItem(5, "Shot Roulette", "Draai het rad, drink het resultaat", 100),
                new ShopItem(6, "Bussen", "Kom op dat weet je wel", 1000)
        );

        shopRepository.saveAll(shopItems);

        // CHALLENGES
        List<Challenge> challenges = List.of(
            new Challenge(1, "ONMV", "Melvin houdt van eten", "Melvin houdt van eten, het is jou doel om minimaal 1 goede hap van hem te stelen ZONDER dat hij het doorheeft", LocalTime.of(2, 0), 100, false),
            new Challenge(2, "ONDR", "Drogeer challenge", "Gebruik het zout uit het zakje om iemands drankje te spiken, je wint wanneer je doelwit een slok neemt", LocalTime.of(0, 1), 100, false)
        );

        challengeRepository.saveAll(challenges);

        // QUIZZES
        List<Quiz> quizzes = List.of(

        );

        quizRepository.saveAll(quizzes);
    }
}
