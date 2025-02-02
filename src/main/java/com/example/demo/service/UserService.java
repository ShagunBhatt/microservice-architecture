package com.example.demo.service;

import com.example.demo.entity.AppUsers;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUsers> findAll() {
        return userRepository.findAll();
    }

    public AppUsers findByName(String name) {
        AppUsers emp = userRepository.findByName(name);
        if (null == emp) {
            throw new EmployeeNotFoundException ("Not found");
        }
        return  emp;
    }

    public AppUsers findByEmail(String email) {
        Optional<AppUsers> usr = userRepository.findByEmail(email);
        if (usr.isEmpty()) {
            throw new EmployeeNotFoundException ("Not found");
        }
        return  usr.get();
    }

}
