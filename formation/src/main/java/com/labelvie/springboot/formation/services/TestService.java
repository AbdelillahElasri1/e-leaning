package com.labelvie.springboot.formation.services;

import com.labelvie.springboot.formation.Models.Test;

import java.util.List;

public interface TestService {
    Test saveTest(Test test);
    List<Test> getAllTests();
    Object getTestById(long id);
    Test updateTest(Test test, long id);
    void deleteTest(long id);
}
