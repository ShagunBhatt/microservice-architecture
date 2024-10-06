package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Employee {
    @Id
    public Long id;

    @Column
    public String name;

    @Column
    public String address;

    public Employee(){}
}
