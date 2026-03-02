package com.example.uni.repositories;

import com.example.uni.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("""
        SELECT d.id, d.name, s.id, s.name, COUNT(c.id)
        FROM Student s
        JOIN s.department d
        LEFT JOIN s.courses c
        GROUP BY d.id, d.name, s.id, s.name
    """)
    List<Object[]> fetchDepartmentData();
}
