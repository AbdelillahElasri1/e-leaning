package com.labelvie.springboot.formation.services.impl;

import com.labelvie.springboot.formation.Models.Answer;
import com.labelvie.springboot.formation.Repository.AnswerRepository;
import com.labelvie.springboot.formation.exception.ResourceNotFoundException;
import com.labelvie.springboot.formation.services.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        super();
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Object getAnswerById(long id) {
        Optional<Answer> answer = answerRepository.findById(id);
        if (answer.isPresent()){
            answer.get();
        }
        return answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Answer","Id",id));
    }

    @Override
    public Answer updateAnswer(Answer answer, long id) {
        // we need to check whether test with given id is exist in DB or not
        Answer existingAnswer = answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Answer","Id",id));
        existingAnswer.setAnswerText(answer.getAnswerText());
        // save existing data
        answerRepository.save(existingAnswer);
        return existingAnswer;
    }

    @Override
    public void deleteAnswer(long id) {
        // check whether a test exist in a DB or not
        answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Answer","Id",id));
        // delete answer from database
        answerRepository.deleteById(id);
    }
}
