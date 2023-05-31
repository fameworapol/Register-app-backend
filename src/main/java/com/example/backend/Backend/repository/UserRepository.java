package com.example.backend.Backend.repository;

import com.example.backend.Backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsByEmail(String email);
}
