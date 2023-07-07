package com.labelvie.springboot.formation.Repository;

import com.labelvie.springboot.formation.Models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
}
