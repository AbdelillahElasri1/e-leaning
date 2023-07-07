package com.labelvie.springboot.formation.services;

import com.labelvie.springboot.formation.Models.Answer;

import java.util.List;

public interface AnswerService {
    Answer saveAnswer(Answer answer);
    List<Answer> getAllAnswers();
    Object getAnswerById(long id);
    Answer updateAnswer(Answer answer, long id);
    void deleteAnswer(long id);
}
