package com.example.backend.Backend.repository;

import com.example.backend.Backend.entity.Course;
import com.example.backend.Backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,String> {
    @Override
    Optional<Course> findById(String s);

    boolean existsById(String s);
}
