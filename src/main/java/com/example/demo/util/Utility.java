package com.example.demo.util;

import com.example.demo.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static List<TaskEntity> copyTaskRequest(TaskRequest taskRequest) {
        List<TaskEntity> tasks = new ArrayList<>();

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskRequest.getTitle());
        taskEntity.setDescription(taskRequest.getDescription());
        taskEntity.setStatus(taskRequest.getStatus());
        taskEntity.setPriority(taskRequest.getPriority());
        taskEntity.setSubmittedBy(taskRequest.getSubmittedBy());

        if (taskRequest.getDeadline() != null)
            taskEntity.setDeadline(LocalDateTime.parse(taskRequest.getDeadline(), DATETIME_FORMATTER));

        if (taskRequest.getCreatedAt() != null)
            taskEntity.setCreatedAt(LocalDateTime.parse(taskRequest.getCreatedAt(), DATETIME_FORMATTER));

        if (taskRequest.getUpdatedAt() != null)
            taskEntity.setUpdatedAt(LocalDateTime.parse(taskRequest.getUpdatedAt(), DATETIME_FORMATTER));
//        taskEntity.setDeadline(taskRequest.getDeadline());
//        taskEntity.setCreatedAt(taskRequest.getCreatedAt());
//        taskEntity.setUpdatedAt(taskRequest.getUpdatedAt());

        tasks.add(taskEntity);

        return tasks;
    }

    public static TaskResponse copyTaskResponse(TaskEntity taskEntity) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskId(taskEntity.getTaskId());
        taskResponse.setTitle(taskEntity.getTitle());
        taskResponse.setDescription(taskEntity.getDescription());
        taskResponse.setStatus(taskEntity.getStatus());
        taskResponse.setPriority(taskEntity.getPriority());
//        taskResponse.setDeadline(taskEntity.getDeadline());
//        taskResponse.setCreatedAt(taskEntity.getCreatedAt());
//        taskResponse.setUpdatedAt(taskEntity.getUpdatedAt());
        taskResponse.setSubmittedBy(taskEntity.getSubmittedBy());


        if (taskEntity.getDeadline() != null)
            taskResponse.setDeadline(taskEntity.getDeadline().format(DATETIME_FORMATTER));
        if (taskEntity.getCreatedAt() != null)
            taskResponse.setCreatedAt(taskEntity.getCreatedAt().format(DATETIME_FORMATTER));
        if (taskEntity.getUpdatedAt() != null)
            taskResponse.setUpdatedAt(taskEntity.getUpdatedAt().format(DATETIME_FORMATTER));

        return taskResponse;
    }

    public static List<TaskResponse> copyTaskResponse(List<TaskEntity> taskEntities) {
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskEntity taskEntity : taskEntities) {
            taskResponses.add(copyTaskResponse(taskEntity));
        }
        return taskResponses;
    }

    public static List<EmployeeEntity> copyEmployeeRequest(EmployeeRequest employeeRequest) {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        EmployeeEntity userEntity = new EmployeeEntity();
        userEntity.setFirstName(employeeRequest.getFirstName());
        userEntity.setLastName(employeeRequest.getLastName());
        userEntity.setEmail(employeeRequest.getEmail());
        userEntity.setPassword(employeeRequest.getPassword());
        userEntity.setUserName(employeeRequest.getUserName());

        employeeEntities.add(userEntity);

        return employeeEntities;
    }

    public static EmployeeResponse copyEmployeeResponse(EmployeeEntity employeeEntity) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setUserId(employeeEntity.getUserId());
        employeeResponse.setFirstName(employeeEntity.getFirstName());
        employeeResponse.setLastName(employeeEntity.getLastName());
        employeeResponse.setEmail(employeeEntity.getEmail());
        employeeResponse.setPassword(employeeEntity.getPassword());
        employeeResponse.setUserName(employeeEntity.getUserName());


        return employeeResponse;
    }

    public static List<EmployeeResponse> copyEmployeeResponse(List<EmployeeEntity> employeeEntities) {
        List<EmployeeResponse> userResponses = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            userResponses.add(copyEmployeeResponse(employeeEntity));
        }
        return userResponses;
    }
    public static List<ProjectEntity> copyProjectRequest(ProjectRequest projectRequest) {
        List<ProjectEntity> projectEntities = new ArrayList<>();
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName(projectRequest.getProjectName());
        projectEntity.setProjectDescription(projectRequest.getProjectDescription());
        projectEntity.setProjectStatus(projectRequest.getProjectStatus());
        if (projectEntity.getStartDate() !=null)
            projectEntity.setStartDate(LocalDate.parse(projectRequest.getStartDate(), DATE_FORMATTER));
        if (projectEntity.getEndDate() !=null)
            projectEntity.setEndDate(LocalDate.parse(projectRequest.getEndDate(), DATE_FORMATTER));
        projectEntities.add(projectEntity);
        return projectEntities;
    }
    public static ProjectResponse copyProjectResponse(ProjectEntity projectEntity) {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setProjectId(projectEntity.getProjectId());
        projectResponse.setProjectName(projectEntity.getProjectName());
        projectResponse.setProjectDescription(projectEntity.getProjectDescription());
        projectResponse.setProjectStatus(projectEntity.getProjectStatus());
        if (projectEntity.getStartDate() !=null)
            projectResponse.setStartDate(projectEntity.getStartDate().format(DATETIME_FORMATTER));
        if (projectEntity.getEndDate() !=null)
            projectResponse.setEndDate(projectEntity.getEndDate().format(DATETIME_FORMATTER));

        return projectResponse;
    }
    public static List<ProjectResponse> copyProjectResponse(List<ProjectEntity> projectEntities) {
        List<ProjectResponse> projectResponses = new ArrayList<>();
        for (ProjectEntity projectEntity : projectEntities) {
            projectResponses.add(copyProjectResponse(projectEntity));
        }
        return projectResponses;
    }
    public static List<RoleEntity> copyRoleRequest(RoleRequest roleRequest) {
        List<RoleEntity> roleEntities = new ArrayList<>();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleRequest.getRoleName());
        roleEntities.add(roleEntity);
        return roleEntities;
    }
    public static RoleResponse copyRoleResponse(RoleEntity roleEntity) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setRoleId(roleEntity.getRoleId());
        roleResponse.setRoleName(roleEntity.getRoleName());
        return roleResponse;
    }
    public static List<RoleResponse> copyRoleResponse(List<RoleEntity> roleEntities) {
        List<RoleResponse> roleResponses = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            roleResponses.add(copyRoleResponse(roleEntity));
        }
        return roleResponses;
    }
    public static List<PermissionEntity> copyPermissionRequest(PermissionRequest permissionRequest) {
        List<PermissionEntity> permissionEntities = new ArrayList<>();
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setPermissionName(permissionRequest.getPermissionName());
        permissionEntities.add(permissionEntity);
        return permissionEntities;
    }
    public static PermissionResponse copyPermissionResponse(PermissionEntity permissionEntity) {
        PermissionResponse permissionResponse = new PermissionResponse();
        permissionResponse.setPermissionId(permissionEntity.getPermissionId());
        permissionResponse.setPermissionName(permissionEntity.getPermissionName());
        return permissionResponse;
    }
    public static List<PermissionResponse> copyPermissionResponse(List<PermissionEntity> permissionEntities) {
        List<PermissionResponse> permissionResponses = new ArrayList<>();
        for (PermissionEntity permissionEntity : permissionEntities) {
            permissionResponses.add(copyPermissionResponse(permissionEntity));
        }
        return permissionResponses;
    }

}
