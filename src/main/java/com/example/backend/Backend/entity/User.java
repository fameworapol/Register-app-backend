package com.example.backend.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "std_user")
public class User extends BaseEntity{
    @Column(nullable = false,unique = true,length = 60)
    private String student_id;

    @Column(nullable = false,length = 60)
    private String student_name;

    @Column(nullable = false,unique = true,length = 60)
    private String email;

    @Column(nullable = false,length = 60)
    private String password;
}
