package com.example.aop.model;

import org.springframework.stereotype.Service;

@Service
public class EmpployeeImpl {

    public String getEmployee(){
        System.out.println("From empImpl");
        return "Hey!! EmployeeImpl here";
    }
}
