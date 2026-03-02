package com.example.uni.Service;

import com.example.uni.dto.DepartmentDTO;
import com.example.uni.dto.StudentDTO;
import com.example.uni.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> getAllDepartments() {

        List<Object[]> rows = departmentRepository.fetchDepartmentData();

        Map<Long, DepartmentDTO> departmentMap = new LinkedHashMap<>();

        for (Object[] row : rows) {

            Long departmentId = (Long) row[0];
            String departmentName = (String) row[1];
            Long studentId = (Long) row[2];
            String studentName = (String) row[3];
            Long coursesCount = (Long) row[4];

            departmentMap.putIfAbsent(
                    departmentId,
                    new DepartmentDTO(departmentName, new ArrayList<>())
            );

            if (studentId != null) {
                departmentMap.get(departmentId)
                        .getStudents()
                        .add(new StudentDTO(studentName, coursesCount));
            }
        }

        return new ArrayList<>(departmentMap.values());
    }
}
