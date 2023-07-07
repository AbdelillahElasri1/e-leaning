package com.labelvie.springboot.formation.Repository;

import com.labelvie.springboot.formation.Models.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtiesRepository extends JpaRepository<Specialties, Long> {
}
