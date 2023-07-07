package com.labelvie.springboot.formation.controllers;

import com.labelvie.springboot.formation.Models.Answer;
import com.labelvie.springboot.formation.Models.Question;
import com.labelvie.springboot.formation.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        super();
        this.answerService = answerService;
    }

    // build create Answer rest api
    @PostMapping
    // http://localhost:8080/api/answers
    public ResponseEntity<Answer> saveAnswer(Answer answer){
        return new ResponseEntity<Answer>(answerService.saveAnswer(answer), HttpStatus.CREATED);
    }
    // build get All Answers rest api
    @GetMapping
    // http://localhost:8080/api/answers
    public List<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }
    // build get Answer by id rest api
    @GetMapping("{id}")
    // http://localhost:8080/api/answers/{id}
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") long answerId){
        return new ResponseEntity<Answer>((Answer) answerService.getAnswerById(answerId), HttpStatus.OK);
    }
    // build update Answer rest api
    @PutMapping("{id}")
    // http://localhost:8080/api/answers/{id}
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") long answerId, @RequestBody Answer answer){
        return new ResponseEntity<Answer>(answerService.updateAnswer(answer,answerId), HttpStatus.OK);
    }
    // build delete Answer rest api
    @DeleteMapping("{id}")
    // http://localhost:8080/api/answers/{id}
    public ResponseEntity<String> deleteAnswer(@PathVariable("id") long answerId){
        // delete from database
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<String>("Answer is deleted successfully", HttpStatus.OK);
    }
}
