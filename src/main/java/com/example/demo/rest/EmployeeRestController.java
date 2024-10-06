package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    EmployeeService employeeService ;

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
