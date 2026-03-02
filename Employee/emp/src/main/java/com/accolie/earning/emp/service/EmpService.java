package com.accolie.earning.emp.service;

import com.accolie.earning.emp.dto.Employee;
import com.accolie.earning.emp.repository.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class EmpService {

    public final EmpRepository repository;


    public EmpService(EmpRepository repository) {
        this.repository = repository;
    }

    public Map<Long, Employee> getAllEmployees(){
        return repository.findAll();
    }

    public String addEmployee(Employee Employee) {
        repository.save(Employee);
        return "Employee added successfully";
    }

    public Employee getEmployeeById(Long id){
        Employee emp = repository.findById(id);
        if(emp == null){
            throw new RuntimeException("Employee may not be present");
        }
        return emp;
    }
    public String deleteEmployee(Long id) {
        repository.delete(id);
        return "Employee deleted successfully";
    }

    public String updateEmployee(Long id,
                                 Employee Employee) {
        repository.save(Employee);
        return "Employee updated successfully";
    }
}
