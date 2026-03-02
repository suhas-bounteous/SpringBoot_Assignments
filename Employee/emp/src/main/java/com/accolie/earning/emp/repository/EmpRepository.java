package com.accolie.earning.emp.repository;

import com.accolie.earning.emp.dto.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class EmpRepository {
    private final Map<Long, Employee> EmployeeMap = new HashMap<>();

    public Map<Long, Employee> findAll() {
        return EmployeeMap;
    }

    public Employee findById(Long id) {
        return EmployeeMap.get(id);
    }

    public void save(Employee Employee) {
        EmployeeMap.put((long) Employee.getId(), Employee);
    }

    public void delete(Long id) {
        EmployeeMap.remove(id);
    }
}
