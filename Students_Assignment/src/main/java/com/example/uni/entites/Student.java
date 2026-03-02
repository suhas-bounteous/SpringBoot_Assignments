package com.example.uni.entites;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ManyToOne
    Department department;

    @OneToMany(mappedBy = "student" , fetch = FetchType.LAZY)
    List<Course> courses;
}
