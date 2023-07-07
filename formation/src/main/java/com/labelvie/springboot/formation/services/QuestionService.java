package com.labelvie.springboot.formation.services;

import com.labelvie.springboot.formation.Models.Question;

import java.util.List;

public interface QuestionService {
    Question saveQuestion(Question question);
    List<Question> getAllQuestions();
    Object getQuestionById(long id);
    Question updateQuestion(Question question, long id);
    void deleteQuestion(long id);
}
