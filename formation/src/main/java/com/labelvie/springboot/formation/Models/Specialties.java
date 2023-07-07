package com.labelvie.springboot.formation.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`Specialties`")
public class Specialties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Specialties")
    private String Specialties;
}
