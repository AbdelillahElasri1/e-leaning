package com.labelvie.springboot.formation.Models;

import com.labelvie.springboot.formation.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`Assignment`")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Assignment_title")
    private String Assignment_title;
    @Column(name = "Assignment_description")
    private String Assignment_description;
    @Column(name = "Assignment_file")
    private String Assignment_file;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
