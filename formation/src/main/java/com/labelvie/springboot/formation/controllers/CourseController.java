package com.labelvie.springboot.formation.controllers;


import com.labelvie.springboot.formation.Models.Course;
import com.labelvie.springboot.formation.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }
    // build create course rest api
    @PostMapping
    // http://localhost:8080/api/courses
    public ResponseEntity<Course> saveCourse(Course course){
        return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.CREATED);
    }
    // build get All Courses rest api
    @GetMapping
    // http://localhost:8080/api/course
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    // build get course by id rest api
    @GetMapping("{id}")
    // http://localhost:8080/api/courses/{id}
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long courseId){
        return new ResponseEntity<Course>((Course) courseService.getCourseById(courseId), HttpStatus.OK);
    }
    // build update course rest api
    @PutMapping("{id}")
    // http://localhost:8080/api/courses/{id}
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long courseId, @RequestBody Course course){
        return new ResponseEntity<Course>(courseService.updateCourse(course,courseId), HttpStatus.OK);
    }
    // build delete course rest api
    @DeleteMapping("{id}")
    // http://localhost:8080/api/courses/{id}
    public ResponseEntity<String> deleteCourse(@PathVariable("id") long courseId){
        // delete from database
        courseService.deleteCourse(courseId);
        return new ResponseEntity<String>("course is deleted successfully", HttpStatus.OK);
    }
}
