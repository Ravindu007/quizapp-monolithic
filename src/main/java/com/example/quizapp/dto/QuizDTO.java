package com.example.quizapp.dto;

import com.example.quizapp.entity.Question;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizDTO {

    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> questions;
}
