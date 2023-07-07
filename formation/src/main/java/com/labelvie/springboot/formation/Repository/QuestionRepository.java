package com.labelvie.springboot.formation.Repository;

import com.labelvie.springboot.formation.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
