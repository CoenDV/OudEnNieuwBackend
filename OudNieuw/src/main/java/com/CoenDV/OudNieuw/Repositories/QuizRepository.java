package com.CoenDV.OudNieuw.Repositories;

import com.CoenDV.OudNieuw.Models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
