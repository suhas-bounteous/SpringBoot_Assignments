package com.example.uni.dto;

public class StudentDTO {

    private String studentName;
    private Long coursesCount;

    public StudentDTO(String studentName, Long coursesCount) {
        this.studentName = studentName;
        this.coursesCount = coursesCount;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getCoursesCount() {
        return coursesCount;
    }
}
