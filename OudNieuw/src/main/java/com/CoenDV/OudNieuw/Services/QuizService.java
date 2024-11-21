package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.DTO.AddPointsRequest;
import com.CoenDV.OudNieuw.Models.DTO.AnswerReply;
import com.CoenDV.OudNieuw.Models.DTO.AnswerRequest;
import com.CoenDV.OudNieuw.Models.Question;
import com.CoenDV.OudNieuw.Models.Quiz;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.QuizRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    UserService userService;
    QuizRepository quizRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    private boolean isQuizRunning = false;
    private Quiz quiz;

    private SimpMessagingTemplate template;

    public QuizService(QuizRepository quizRepository, UserService userService, SimpMessagingTemplate template, ObjectMapper objectMapper) {
        this.quizRepository = quizRepository;
        this.userService = userService;
        this.template = template;
        this.objectMapper = objectMapper;
    }

    public boolean startQuiz(int quizId) {
        if (!isQuizRunning) {
            System.out.println("Starting quiz");
            isQuizRunning = true;
            quiz = quizRepository.findById(quizId).get();
            template.convertAndSend("/topic/quiz-mainscreen", true);
            return true;
        }
        return false;
    }

    @MessageMapping("/nextQuestion")
    @SendTo("/topic/quiz-mainscreen")
    public boolean nextQuestion() {
        if (isQuizRunning) {
            System.out.println("Getting next question");
            Question question = quiz.getNextQuestion();

            if (question == null) {
                template.convertAndSend("/topic/quiz-mainscreen", false);
                isQuizRunning = false;
                return false;
            }

            template.convertAndSend("/topic/quiz-mainscreen", question);
            return true;
        }
        return false;
    }

    public void showAnswer() throws JsonProcessingException {
        if (isQuizRunning) {
            System.out.println("Showing answer");
            template.convertAndSend("/topic/quiz-mainscreen", objectMapper.writeValueAsString("showAnswer"));
        }
    }

    public AnswerReply answerQuestion(AnswerRequest answer) {

        System.out.println("Answer: " + answer);

        AnswerReply reply = new AnswerReply();
        if (quiz.getCorrectAnswer(answer.getAnswer())) {
            User user = userService.addPoints(new AddPointsRequest(userService.getUserById(answer.getUserId()).getUsername(), 10));
            reply.setUser(user);
            reply.setPoints(10);
            System.out.println("Correct answer: " + reply);
            return reply;
        } else {
            reply.setUser(userService.getUserById(answer.getUserId()));
            reply.setPoints(0);
            return reply;
        }
    }

    public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }
}
