package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.DTO.AddPointsRequest;
import com.CoenDV.OudNieuw.Models.DTO.AnswerReply;
import com.CoenDV.OudNieuw.Models.DTO.AnswerRequest;
import com.CoenDV.OudNieuw.Models.Question;
import com.CoenDV.OudNieuw.Models.Quiz;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Services.QuizService;
import com.CoenDV.OudNieuw.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/", "https://oudennieuw.onrender.com/", "https://oud-en-nieuw-backend-git-coen-de-vries-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/"})
@RequestMapping("quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("start/{quizId}")
    public boolean startQuiz(@PathVariable int quizId) {
        return quizService.startQuiz(quizId);
    }

    @PostMapping("next")
    public boolean nextQuestion() {
        return quizService.nextQuestion();
    }

    @PostMapping("answer")
    public void showAnswer() throws JsonProcessingException {
        quizService.showAnswer();
    }

    @GetMapping
    public List<Quiz> getQuizzes() {
        return quizService.getQuizzes();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public AnswerReply answerQuestion(AnswerRequest answer) {
        return quizService.answerQuestion(answer);
    }
}
