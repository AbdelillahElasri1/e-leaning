package com.labelvie.springboot.formation.controllers;

import com.labelvie.springboot.formation.Models.Question;
import com.labelvie.springboot.formation.Models.Test;
import com.labelvie.springboot.formation.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        super();
        this.questionService = questionService;
    }

    // build create question rest api
    @PostMapping
    // http://localhost:8080/api/questions
    public ResponseEntity<Question> saveQuestion(Question question){
        return new ResponseEntity<Question>(questionService.saveQuestion(question), HttpStatus.CREATED);
    }
    // build get All Questions rest api
    @GetMapping
    // http://localhost:8080/api/questions
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    // build get Questions by id rest api
    @GetMapping("{id}")
    // http://localhost:8080/api/questions/{id}
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") long questionId){
        return new ResponseEntity<Question>((Question) questionService.getQuestionById(questionId), HttpStatus.OK);
    }
    // build update Question rest api
    @PutMapping("{id}")
    // http://localhost:8080/api/questions/{id}
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") long questionId, @RequestBody Question question){
        return new ResponseEntity<Question>(questionService.updateQuestion(question,questionId), HttpStatus.OK);
    }
    // build delete Question rest api
    @DeleteMapping("{id}")
    // http://localhost:8080/api/questions/{id}
    public ResponseEntity<String> deleteTest(@PathVariable("id") long questionId){
        // delete from database
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<String>("Question is deleted successfully", HttpStatus.OK);
    }
}
