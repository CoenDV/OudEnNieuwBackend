package com.CoenDV.OudNieuw.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    private int quizId;
    @OneToMany(fetch = FetchType.EAGER)
    List<Question> questions;
    private int currentQuestionIndex;

    public Question getNextQuestion() {

        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0;
            return null;
        }

        Question nextQuestion = questions.get(currentQuestionIndex);
        currentQuestionIndex++;

        return nextQuestion;
    }

    public boolean getCorrectAnswer(String answer) {
        Question currentQuestion;
        if (currentQuestionIndex - 1 < 0)
            currentQuestion = questions.get(questions.size() - 1);
        else
            currentQuestion = questions.get(currentQuestionIndex - 1);

        System.out.println(currentQuestion);
        System.out.println(answer);
        return currentQuestion.getAnswer().equals(answer);
    }
}
