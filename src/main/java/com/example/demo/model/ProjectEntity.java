package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Project")
public class ProjectEntity {
    @Id
    @GeneratedValue
    @Column(name="Project_ID")
    private Integer projectId;

    @Column(name = "Project_Name")
    private String projectName;
    @Column(name="Project_Description")
    private String projectDescription;
    @Column(name = "Project_Status")
    private String projectStatus;
    @Column(name = "Start_Date")
    private LocalDate startDate;
    @Column(name = "End_Date")
    private LocalDate endDate;

    @ManyToMany(mappedBy = "project")
    private Set<EmployeeEntity> employee = new HashSet<>();
}
