package com.example.demo.model;

import lombok.Data;

@Data
public class TaskResponse {
    private int taskId;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String deadline;
    private String createdAt;
    private String updatedAt;
    private String submittedBy;
}
