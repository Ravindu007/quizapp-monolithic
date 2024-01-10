package com.example.quizapp.controllers;

import com.example.quizapp.dto.QuestionDTO;
import com.example.quizapp.dto.ResponseDTO;
import com.example.quizapp.entity.Question;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveQuestion") // api/v1/question/saveQuestion
    public ResponseEntity saveQuestion(@RequestBody QuestionDTO questionDto){
        try{
            String res = questionService.saveQuestion(questionDto);

            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("success");
                responseDTO.setContent(questionDto);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else{
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("bad request");
                responseDTO.setContent(null);

                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage("bad request");
            responseDTO.setContent(null);

            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/getAllquestions")
    public ResponseEntity getAllQuestions(){
        try {
            List<QuestionDTO> questioinDtoList = questionService.getAllQuestions();

            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("success");
            responseDTO.setContent(questioinDtoList);

            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage("bad request");
            responseDTO.setContent(null);

            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }
}
