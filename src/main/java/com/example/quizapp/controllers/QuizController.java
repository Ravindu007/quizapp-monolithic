package com.example.quizapp.controllers;

import com.example.quizapp.dto.ResponseDTO;
import com.example.quizapp.repo.QuizRepo;
import com.example.quizapp.service.QuizService;
import com.example.quizapp.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    ResponseDTO responseDTO;

//    create a quiz
    @PostMapping("/create")
    public ResponseEntity createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        try{
            String res = quizService.saveQuiz(category, numQ, title);

            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("success");

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
}


