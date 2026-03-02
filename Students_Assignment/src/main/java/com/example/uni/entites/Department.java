package com.example.uni.entites;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    @OneToMany(mappedBy = "department" , fetch = FetchType.LAZY)
    List<Student> Students;

}
