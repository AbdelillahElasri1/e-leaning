package com.labelvie.springboot.formation.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "`test`")

public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Test_title")
    private String Test_title;
    @Column(name = "Test_description")
    private String Test_description;
//    @Column(name = "Test_file")
//    private String Test_file;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    public Test(Long id, String test_title, String test_description, String test_file, Course course , List<Question> questions) {
        this.id = id;
        Test_title = test_title;
        Test_description = test_description;
//        Test_file = test_file;
        this.questions = questions;
        this.course = course;
    }
    public Test(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest_title() {
        return Test_title;
    }

    public void setTest_title(String test_title) {
        Test_title = test_title;
    }

    public String getTest_description() {
        return Test_description;
    }

    public void setTest_description(String test_description) {
        Test_description = test_description;
    }

//    public String getTest_file() {
//        return Test_file;
//    }
//
//    public void setTest_file(String test_file) {
//        Test_file = test_file;
//    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
