package com.labelvie.springboot.formation.Models;

import com.labelvie.springboot.formation.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "`Course`")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Course_title")
    private String Course_title;
    @Column(name = "Course_description")
    private String Course_description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "course")
    private List<Test> tests;

    public Course(Long id, String course_title, String course_description, User user, List<Test> tests) {
        this.id = id;
        Course_title = course_title;
        Course_description = course_description;
        this.user = user;
        this.tests = tests;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse_title() {
        return Course_title;
    }

    public void setCourse_title(String course_title) {
        Course_title = course_title;
    }

    public String getCourse_description() {
        return Course_description;
    }

    public void setCourse_description(String course_description) {
        Course_description = course_description;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
