package com.labelvie.springboot.formation.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`answer`")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answerText;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(Long id, String answerText, Question question) {
        this.id = id;
        this.answerText = answerText;
        this.question = question;
    }
    public Answer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
