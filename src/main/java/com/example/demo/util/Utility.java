package com.example.demo.util;

import com.example.demo.model.*;

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
}
