package com.example.quizapp.service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repo.QuestionRepo;
import com.example.quizapp.repo.QuizRepo;
import com.example.quizapp.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    ModelMapper modelMapper;


    public String saveQuiz(String category, int numQ, String title){
        List<Question> questions = questionRepo.findRandojmQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepo.save(modelMapper.map(quiz, Quiz.class));
        return VarList.RSP_SUCCESS;
    }

}

