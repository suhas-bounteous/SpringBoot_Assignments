package com.example.uni.dto;

import java.util.List;

public class DepartmentDTO {

    private String departmentName;
    private List<StudentDTO> students;

    public DepartmentDTO(String departmentName, List<StudentDTO> students) {
        this.departmentName = departmentName;
        this.students = students;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }
}
