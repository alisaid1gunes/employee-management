package com.asg.departmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "code",nullable = false, unique = true)
    private String code;

}
