package com.example.demo.repository;

import com.example.demo.entity.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUsers, Long> {

    AppUsers findByName(String name);

    Optional<AppUsers> findByEmail(String email);

}
