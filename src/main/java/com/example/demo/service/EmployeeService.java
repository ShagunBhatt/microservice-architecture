package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findByName(String name) {
        Employee emp = employeeRepository.findByName(name);
        if (null == emp) {
            throw new EmployeeNotFoundException ("Not found");
        }
        return  emp;
    }

}
