package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Task")
public class TaskEntity {
    @Id
    @Column(name = "Task_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private String status;
    @Column(name = "Priority")
    private String priority;
    @Column(name = "Dead_Line")
    private LocalDateTime deadline;
    @Column(name = "Created_At")
    private LocalDateTime createdAt;
    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;
    @Column(name = "Submitted_By")
    private String submittedBy;


    @ManyToMany(mappedBy = "task")
private Set<EmployeeEntity> employee = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "Project_ID")
    private ProjectEntity project;

}
