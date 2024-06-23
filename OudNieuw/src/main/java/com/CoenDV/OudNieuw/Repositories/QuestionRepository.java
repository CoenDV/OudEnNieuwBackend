package com.CoenDV.OudNieuw.Repositories;

import com.CoenDV.OudNieuw.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
