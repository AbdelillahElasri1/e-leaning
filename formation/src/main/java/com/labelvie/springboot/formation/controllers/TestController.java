package com.labelvie.springboot.formation.controllers;

import com.labelvie.springboot.formation.Models.Course;
import com.labelvie.springboot.formation.Models.Test;
import com.labelvie.springboot.formation.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {
    private TestService testService;

    public TestController(TestService testService) {
        super();
        this.testService = testService;
    }
    // build create test rest api
    @PostMapping
    // http://localhost:8080/api/tests
    public ResponseEntity<Test> saveTest(Test test){
        return new ResponseEntity<Test>(testService.saveTest(test), HttpStatus.CREATED);
    }
    // build get All test rest api
    @GetMapping
    // http://localhost:8080/api/tests
    public List<Test> getAllTests(){
        return testService.getAllTests();
    }
    // build get test by id rest api
    @GetMapping("{id}")
    // http://localhost:8080/api/tests/{id}
    public ResponseEntity<Test> getTestById(@PathVariable("id") long testId){
        return new ResponseEntity<Test>((Test) testService.getTestById(testId), HttpStatus.OK);
    }
    // build update test rest api
    @PutMapping("{id}")
    // http://localhost:8080/api/tests/{id}
    public ResponseEntity<Test> updateTest(@PathVariable("id") long testId, @RequestBody Test test){
        return new ResponseEntity<Test>(testService.updateTest(test,testId), HttpStatus.OK);
    }
    // build delete test rest api
    @DeleteMapping("{id}")
    // http://localhost:8080/api/tests/{id}
    public ResponseEntity<String> deleteTest(@PathVariable("id") long testId){
        // delete from database
        testService.deleteTest(testId);
        return new ResponseEntity<String>("Test is deleted successfully", HttpStatus.OK);
    }
}
