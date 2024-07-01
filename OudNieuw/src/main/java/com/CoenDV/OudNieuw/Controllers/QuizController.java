package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.DTO.AddPointsRequest;
import com.CoenDV.OudNieuw.Models.DTO.AnswerReply;
import com.CoenDV.OudNieuw.Models.DTO.AnswerRequest;
import com.CoenDV.OudNieuw.Models.Question;
import com.CoenDV.OudNieuw.Models.Quiz;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Services.QuizService;
import com.CoenDV.OudNieuw.Services.UserService;
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
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("quiz")
public class QuizController {

    private boolean isQuizRunning = false;
    private Quiz quiz;

    @Autowired
    private SimpMessagingTemplate template;

    QuizService quizService;
    UserService userService;

    public QuizController(QuizService quizService, UserService userService) {
        this.quizService = quizService;
        this.userService = userService;
    }

    @PostMapping("start")
    public void startQuiz() {
        if (!isQuizRunning) {
            quiz = quizService.startQuiz();
            isQuizRunning = true;
        }
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public AnswerReply answerQuestion(AnswerRequest answer) {

        System.out.println("Answer: " + answer);

        AnswerReply reply = new AnswerReply();
        if (quiz.getCorrectAnswer(answer.getAnswer())) {
            User user = userService.addPoints(new AddPointsRequest(userService.getUserById(answer.getUserId()).getUsername(), 100));
            reply.setUser(user);
            reply.setPoints(100);
            System.out.println("Correct answer: " + reply);
            return reply;
        } else {
            reply.setUser(userService.getUserById(answer.getUserId()));
            reply.setPoints(0);
            return reply;
        }
    }

    @Scheduled(fixedRate = 5000)
    @MessageMapping("/nextQuestion")
    @SendTo("/topic/quiz-mainscreen")
    public void getNextQuestion() {
        System.out.println("Getting next question");
        if (isQuizRunning) {
            Question question = quiz.getNextQuestion();

            if (question == null) {
                isQuizRunning = false;
                return;
            }

            template.convertAndSend("/topic/quiz-mainscreen", question);
        }
    }
}
