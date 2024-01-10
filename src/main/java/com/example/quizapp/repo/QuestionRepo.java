package com.example.quizapp.repo;

import com.example.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
