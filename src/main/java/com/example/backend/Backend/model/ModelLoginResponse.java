package com.example.backend.Backend.model;

import lombok.Data;

@Data
public class ModelLoginResponse {
    private String token = "";
    private String student_id;
    private String student_name;
}
