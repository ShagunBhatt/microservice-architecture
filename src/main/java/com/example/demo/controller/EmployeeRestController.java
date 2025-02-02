package com.example.demo.controller;

import com.example.demo.DTOs.RegisterUserDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    EmployeeService employeeService ;

    @PostMapping("/create")
    public ResponseEntity<Employee> register(@RequestBody RegisterUserDto registerUserDto) {
        //Create a user
        Employee createdUser = employeeService.create(registerUserDto);

        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/all")
    public List<Employee> findAll(){
        log.info("Call to finalAll API");
        return employeeService.findAll();
    }

    @GetMapping("/name")
    public Employee findByName(@RequestParam String name){
        log.info("Call to finalAll API with name {}",name);
        return employeeService.findByName(name);
    }
}
