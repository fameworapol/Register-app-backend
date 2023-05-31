package com.example.backend.Backend.model;

import lombok.Data;

@Data
public class ModelRegsiterRequest {
    private String student_id;
    private String student_name;
    private String email;
    private String password;
}
