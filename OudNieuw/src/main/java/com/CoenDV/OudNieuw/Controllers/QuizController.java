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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/", "https://oudennieuw.onrender.com/"})
@RequestMapping("quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("start")
    public boolean startQuiz() {
        return quizService.startQuiz();
    }

    @PostMapping("next")
    public boolean nextQuestion() {
        return quizService.nextQuestion();
    }

    @PostMapping("answer")
    public void showAnswer() throws JsonProcessingException {
        quizService.showAnswer();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public AnswerReply answerQuestion(AnswerRequest answer) {
        return quizService.answerQuestion(answer);
    }
}
