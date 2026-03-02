package com.accolie.earning.emp.dto;

import lombok.Setter;

public class Employee {
    private long id;
    @Setter
    private String name;
    @Setter
    private String dept;

    Employee(int id, String name, String dept){
        this.id=id;
        this.name=name;
        this.dept=dept;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

}
