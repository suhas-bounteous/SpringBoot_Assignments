package com.example.aop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("api/emp")
public class Employee {

    @Autowired
    EmpployeeImpl empImpl;

    @GetMapping("/get3")
    public String getEmpployee() {
        System.out.println("First employee");
        return empImpl.getEmployee();
    }
}
