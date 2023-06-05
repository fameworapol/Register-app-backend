package com.example.backend.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "course_enrolled")
public class Enrolled extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;
}
