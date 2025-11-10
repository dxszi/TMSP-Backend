package com.example.demo.service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.TaskEntity;
import com.example.demo.model.TaskResponse;
import com.example.demo.repositoty.TaskRepository;
import com.example.demo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {



    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> saveTask(List<TaskEntity> taskEntities){
        return taskRepository.saveAll(taskEntities);
    }

    public List<TaskEntity>findAllTasks(){
        return taskRepository.findAll();
    }

    public void deleteTask(Integer taskId){
        taskRepository.deleteById(taskId);
    }
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        try{
            List<TaskEntity> taskEntities = findAllTasks();

            if (taskEntities == null || taskEntities.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<TaskResponse> taskResponse = Utility.copyTaskResponse(taskEntities);
            return ResponseEntity.ok(taskResponse);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //public List<TaskEntity> findAllTasksByUserName(String userName){}

    public List<TaskEntity> findByTitle(String title){
        return taskRepository.findByTitle(title);
    }
    public List<TaskEntity> findByStatus(String status){
        return taskRepository.findByStatus(status);
    }
    public List<TaskEntity> findByPriority(String priority){
        return taskRepository.findByPriority(priority);
    }
    public List<TaskEntity> findBySubmittedBy(String submittedBy){
        return taskRepository.findBySubmittedBy(submittedBy);
    }
    public List<TaskEntity> findByTaskId(Integer taskId){
        return taskRepository.findByTaskId(taskId);
    }
    public List<TaskEntity> findByStatusAndSubmittedBy(String status, String submittedBy){
        return taskRepository.findByStatusAndSubmittedBy(status, submittedBy);
    }

    public ResponseEntity<?> getEmployeesByTaskId(Integer taskId){
        TaskEntity taskEntity = taskRepository.findById(taskId).orElse(null);
        if (taskEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
        List<EmployeeEntity> employeeEntities = new ArrayList<>(taskEntity.getEmployee());
        return ResponseEntity.ok(Utility.copyEmployeeResponse(employeeEntities));
    }
}