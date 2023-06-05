package com.example.backend.Backend.service;

import com.example.backend.Backend.entity.User;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public User createUser(String student_name,String student_id,String email,String password) throws UserException {
        User entity = new User();
        if(userRepository.existsByEmail(email)){
            throw UserException.emailAlreadyExist();
        }
        entity.setEmail(email);
        entity.setStudent_id(student_id);
        entity.setStudent_name(student_name);
        entity.setPassword(passwordEncoder.encode(password));
        return userRepository.save(entity);
    }
}
