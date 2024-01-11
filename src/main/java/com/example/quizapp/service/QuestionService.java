package com.example.quizapp.service;

import com.example.quizapp.dto.QuestionDTO;
import com.example.quizapp.entity.Question;
import com.example.quizapp.repo.QuestionRepo;
import com.example.quizapp.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveQuestion(QuestionDTO questionDto){
        if(questionRepo.existsById(questionDto.getId())){
            return VarList.RSP_DUPLICATED;
        }else{
            questionRepo.save(modelMapper.map(questionDto, Question.class));
            return VarList.RSP_SUCCESS;
        }
    }


    public List<QuestionDTO> getAllQuestions(){
        List<Question> questionList = questionRepo.findAll();

        return modelMapper.map(questionList, new TypeToken<ArrayList<QuestionDTO>>(){}.getType());
    }

    public List<QuestionDTO> getAllQuestionsByCateogry(String category) {
        List<Question> questionList =  questionRepo.findByCategory(category);
        return modelMapper.map(questionList, new TypeToken<ArrayList<QuestionDTO>>(){}.getType());
    }
}
