package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or GenerationType.AUTO
    private Long id;

    @Column
    private String name;

    @Column
    private String address;
}
