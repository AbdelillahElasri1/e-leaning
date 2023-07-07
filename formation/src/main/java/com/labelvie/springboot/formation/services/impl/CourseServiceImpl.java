package com.labelvie.springboot.formation.services.impl;

import com.labelvie.springboot.formation.Models.Course;
import com.labelvie.springboot.formation.Repository.CourseRepository;
import com.labelvie.springboot.formation.exception.ResourceNotFoundException;
import com.labelvie.springboot.formation.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Object getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()){
            return course.get();
        }
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course","Id",id));
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        // we need to check whether course with given id is course in DB or not
        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "Id", id));
        existingCourse.setCourse_title(course.getCourse_title());
        existingCourse.setCourse_description(course.getCourse_description());
        // save existing course to DB
        courseRepository.save(existingCourse);
        return existingCourse;
    }

    @Override
    public void deleteCourse(Long id) {
        // check whether a course exist in a DB or not
        courseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Course", "Id", id));
        courseRepository.deleteById(id);
    }
}
