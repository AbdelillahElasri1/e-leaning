package com.labelvie.springboot.formation.services;

import com.labelvie.springboot.formation.Models.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> getAllCourses();
    Object getCourseById(Long id);
    Course updateCourse(Course course, Long id);
    void deleteCourse(Long id);
}
