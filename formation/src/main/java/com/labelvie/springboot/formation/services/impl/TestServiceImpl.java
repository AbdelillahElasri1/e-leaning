package com.labelvie.springboot.formation.services.impl;

import com.labelvie.springboot.formation.Models.Course;
import com.labelvie.springboot.formation.Models.Test;
import com.labelvie.springboot.formation.Repository.TestRepository;
import com.labelvie.springboot.formation.exception.ResourceNotFoundException;
import com.labelvie.springboot.formation.services.TestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        super();
        this.testRepository = testRepository;
    }

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Object getTestById(long id) {
        Optional<Test> test = testRepository.findById(id);
        if (test.isPresent()){
            return test.get();
        }
        return testRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Test","Id",id));
    }

    @Override
    public Test updateTest(Test test, long id) {
        // we need to check whether test with given id is exist in DB or not
        Test existingTest = testRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Test", "Id", id));
        existingTest.setTest_title(test.getTest_title());
        existingTest.setTest_description(test.getTest_description());
//        existingTest.setTest_file(test.getTest_file());
        // save existing test to DB
        testRepository.save(existingTest);
        return existingTest;
    }

    @Override
    public void deleteTest(long id) {
        // check whether a test exist in a DB or not
        testRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Test", "Id", id));
        testRepository.deleteById(id);
    }
}
