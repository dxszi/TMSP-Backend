package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @Column(name ="User_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "User_Name",nullable = false, unique = true)
    private String userName;
    @Column(name = "Email", unique = true)
    private String email;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Password", nullable = false)
    private String password;



@ManyToMany
@JoinTable(name = "employee_task",joinColumns = @JoinColumn(name = "User_ID"),inverseJoinColumns = @JoinColumn(name = "Task_ID"))
private Set<TaskEntity> task = new HashSet<>();

@ManyToOne
@JoinColumn(name = "Role_ID")
private RoleEntity roleEntity;

@ManyToMany
@JoinTable(name = "employee_task", joinColumns = @JoinColumn(name = "User_ID"), inverseJoinColumns = @JoinColumn(name = "Project_ID"))
private Set<ProjectEntity> project = new HashSet<>();

}
