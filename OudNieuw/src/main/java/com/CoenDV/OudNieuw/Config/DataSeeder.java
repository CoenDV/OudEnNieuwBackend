package com.CoenDV.OudNieuw.Config;

import com.CoenDV.OudNieuw.Models.*;
import com.CoenDV.OudNieuw.Models.Enums.ObjectType;
import com.CoenDV.OudNieuw.Models.Enums.Role;
import com.CoenDV.OudNieuw.Repositories.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class DataSeeder implements ApplicationRunner {

    UserRepository userRepository;
    QuizRepository quizRepository;
    QuestionRepository questionRepository;
    ShopRepository shopRepository;
    ChallengeRepository challengeRepository;

    public DataSeeder(UserRepository userRepository, QuizRepository quizRepository, QuestionRepository questionRepository, ShopRepository shopRepository, ChallengeRepository challengeRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.shopRepository = shopRepository;
        this.challengeRepository = challengeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // USERS
//        List<User> users = List.of(
//                new User(1, "Melvin", Role.ROLE_USER, 1000, null),
//                new User(2, "Jeffrey", Role.ROLE_USER, 0, null),
//                new User(3, "Daniel", Role.ROLE_USER, 0, null),
//                new User(4, "Bjorn", Role.ROLE_USER, 0, null),
//                new User(5, "Quinty", Role.ROLE_USER, 0, null),
//                new User(6, "Femke", Role.ROLE_USER, 0, null)
//        );
//
//        userRepository.saveAll(users);
//
//        int pointsForRondjeShotjes = (users.size() - 1) * 100;
//
//        // SHOP ITEMS
//        List<ShopItem> shopItems = List.of(
//                new ShopItem(1, "Shotje 20", "Deel 1 shotje van min 20% uit", 100, ObjectType.SHOPITEM),
//                new ShopItem(2, "Steen Papier Schaar", "Best of 3 verliezer neemt een shotje van min 20%", 80, ObjectType.SHOPITEM),
//                new ShopItem(3, "Rondje Shotjes", "Iedereen neemt een shotje van min 20%, ja ook jij", pointsForRondjeShotjes, ObjectType.SHOPITEM),
//                new ShopItem(4, "Snake Eyes", "Activeer snake eyes voor jezelf, als iemand je aan kijkt neemt dat persoon een slok, 15min", 100, ObjectType.SHOPITEM),
//                new ShopItem(5, "Shot Roulette", "Draai het rad, drink het resultaat", 100, ObjectType.SHOPITEM),
//                new ShopItem(6, "Bussen", "Kom op dat weet je wel", 1000, ObjectType.SHOPITEM),
//                new ShopItem(7, "Atje", "Laat iemand een atje zetten", 200, ObjectType.SHOPITEM),
//                new ShopItem(8, "Spicy", "Laat iemand een theelepel pittige saus eten", 50, ObjectType.SHOPITEM),
//                new ShopItem(9, "Krokodil", "Speel het krokodillen spel totdat er iemand moet drinken", 100, ObjectType.SHOPITEM),
//                new ShopItem(10, "Double Or Nothing", "Kies een speler om een munt op te gooien. Als het kop is, moet hij/zij dubbel drinken voor 5 minuten; als het munt is, hoeft hij/zij niet te drinken.", 100, ObjectType.SHOPITEM),
//                new ShopItem(11, "Pauze", "Neem een pauze van 5 minuten waarin jij niet hoeft te drinken, maar iemand anders wel voor jou moet drinken wanneer jij normaal zou moeten drinken", 100, ObjectType.SHOPITEM),
//                new ShopItem(12, "BDSM", "boei 2 mensen samen voor 10 minuten", 100, ObjectType.SHOPITEM),
//                new ShopItem(13, "Cupido", "Kies 2 mensen die plotseling diep verliefd worden en graag alles samen willen drinken", 100, ObjectType.SHOPITEM),
//                new ShopItem(99, "UNO Reverse Card", "Zet deze kaart in wanneer iemand jou iets forceert te doen, deze speler moet het nu zelf doen!", 0, ObjectType.SECRET),
//                new ShopItem(100, "Mystery Box", "Wie weet wat er allemaal in kan zitten", 250, ObjectType.SHOPITEM) // Must always be last index so it cant be selected by random roll
//        );
//
//        shopRepository.saveAll(shopItems);
//
//        // CHALLENGES
//        List<Challenge> challenges = List.of(
//                new Challenge(1, "ONMV", "Melvin houdt van eten", "Melvin houdt van eten, het is jou doel om minimaal 1 goede hap van hem te stelen ZONDER dat hij het doorheeft", LocalTime.of(2, 0), 100, false),
//                new Challenge(2, "ONDR", "Drogeer challenge", "Gebruik het zout uit het zakje om iemands drankje te spiken, je wint wanneer je doelwit een slok neemt", LocalTime.of(0, 1), 100, false),
//                new Challenge(3, "ONKN", "Teddy bear", "Geef 1 persson 5x een knuffel, binnen 30min", LocalTime.of(0, 30), 100, false),
//                new Challenge(4, "ONOB", "Waarom pakt hij dit aan?", "Geef iemand een random object aan zonder dat de ander er bewust van is dat ze het aanpakken (bijvoorbeeld tijdens het bellen)", LocalTime.of(2, 0), 100, false)
//        );
//
//        challengeRepository.saveAll(challenges);
//
//        // QUESTIONS
//        List<Question> questions = List.of(
//                new Question(0, "Wat is de snelheid van sperma als een man klaar komt?", "45 km/h", List.of("45 km/h", "50 km/h", "35 km/h", "30 km/h"), "Oftewel 12,5 meter per seconde", ObjectType.QUESTION),
//                new Question(1, "Hoeveel procent van de wereldbevolking is roodharig?", "2%", List.of("2%", "1%", "3%", "4%"), "Roodharigen zijn zeldzaam", ObjectType.QUESTION),
//                new Question(2, "Volgens Melvin welk liedje moet het Nederlandse volkslied worden?", "unox", List.of("unox", "Bicycle Chain", "Pokemon song"), "Tja...", ObjectType.QUESTION),
//                new Question(3, "Wat is de verste ejaculatie?", "6 meter", List.of("6 meter", "4 meter", "5 meter", "3 meter"), "", ObjectType.QUESTION),
//                new Question(4, "Hoeveel hamburgers verkoopt McDonalds per seconde?", "75", List.of("75", "100", "50", "25"), "Dit geldt voor alle macdonalds wereldwijd", ObjectType.QUESTION),
//                new Question(5, "Wat is het record voor de langste erectie bij een man (in uren)?", "12 uur", List.of("15 uur", "12 uur", "10 uur", "20 uur"), "", ObjectType.QUESTION),
//                new Question(6, "Hoeveel procent van de wereldbevolking is linkshandig?", "10%", List.of("10%", "5%", "15%", "20%"), "Linkshandigen zijn zeldzaam", ObjectType.QUESTION)
//        );
//
//        questionRepository.saveAll(questions);
//
//        // QUIZ
//        Quiz quiz = new Quiz(1, questions, 0);
//
//        quizRepository.save(quiz);
    }
}
