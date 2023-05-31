package com.example.backend.Backend.model;

import lombok.Data;

@Data
public class ModelCourseRequest {
    private String course_id;
    private String course_name;
    private Integer open;
}
