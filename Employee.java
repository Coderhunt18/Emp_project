package com.hcl.spring.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data // Provides Getters, Setters, ToString, EqualsAndHashCode, and RequiredArgsConstructor,
@Entity // Required for JPA
@Table(name = "employees")
public class Employee {

    @Id // Required for JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically sets id value when saved to DB
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}