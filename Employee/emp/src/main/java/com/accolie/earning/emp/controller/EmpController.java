package com.accolie.earning.emp.controller;

import com.accolie.earning.emp.dto.Employee;
import com.accolie.earning.emp.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@Controller
public class EmpController {

    public final EmpService service;

    public EmpController(EmpService service) {
        this.service = service;
    }

    @GetMapping
    public Map<Long, Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){ return service.getEmployeeById(id);}

    @PostMapping
    public String addEmplyee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public String updateEmplyee(@PathVariable Long id, @RequestBody Employee Employee) {
        return service.updateEmployee(id, Employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }

}
