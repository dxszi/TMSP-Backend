package com.example.demo.model;

import lombok.Data;

@Data
public class ProjectResponse {
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectStatus;
    private String startDate;
    private String endDate;
}
