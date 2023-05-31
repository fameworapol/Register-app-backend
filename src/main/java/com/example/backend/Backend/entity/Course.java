package com.example.backend.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "course")
public class Course extends BaseEntity{
    @Column(nullable = false,length = 60,unique = true)
    private String course_id;

    @Column(nullable = false,length = 60)
    private String course_name;

    @Column(nullable = false,length = 60)
    private Integer open;

}
