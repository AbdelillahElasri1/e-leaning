package com.labelvie.springboot.formation.services.impl;

import com.labelvie.springboot.formation.Models.Question;
import com.labelvie.springboot.formation.Repository.QuestionRepository;
import com.labelvie.springboot.formation.exception.ResourceNotFoundException;
import com.labelvie.springboot.formation.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Object getQuestionById(long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()){
            question.get();
        }
        return questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question", "Id",id));
    }

    @Override
    public Question updateQuestion(Question question, long id) {
        // we need to check whether test with given id is exist in DB or not
        Question existingQuestion = questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question","Id",id));
        existingQuestion.setQuestionText(question.getQuestionText());
        // save data into databases
        questionRepository.save(existingQuestion);
        return existingQuestion;
    }

    @Override
    public void deleteQuestion(long id) {
        // check whether a test exist in a DB or not
        questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question","Id", id));
        // delete question from DB
        questionRepository.deleteById(id);
    }
}
