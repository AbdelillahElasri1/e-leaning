package com.labelvie.springboot.formation.Repository;

import com.labelvie.springboot.formation.Models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
}
