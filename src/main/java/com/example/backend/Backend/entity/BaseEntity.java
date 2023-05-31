package com.example.backend.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GenericGenerator(name="uuid2",strategy = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    @Column(length = 36,nullable = false,updatable = false)
    private String id;
}
