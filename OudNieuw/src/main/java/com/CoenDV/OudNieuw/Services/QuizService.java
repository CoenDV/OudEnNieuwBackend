package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.DTO.AnswerReply;
import com.CoenDV.OudNieuw.Models.Quiz;
import com.CoenDV.OudNieuw.Repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.TimerTask;

@Service
public class QuizService {

    QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz startQuiz() {
        return quizRepository.findById(1).get();
    }
}
