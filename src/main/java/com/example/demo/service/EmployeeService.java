package com.example.demo.service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.EmployeeResponse;
import com.example.demo.model.TaskEntity;
import com.example.demo.model.TaskResponse;
import com.example.demo.repositoty.EmployeeRepository;
import com.example.demo.repositoty.TaskRepository;
import com.example.demo.util.Utility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskRepository taskRepository;

    public List<EmployeeEntity> saveUser(List<EmployeeEntity> employeeEntities){
        return employeeRepository.saveAll(employeeEntities);
    }
    public List<EmployeeEntity> findAllUsers(){
        return employeeRepository.findAll();
    }
    public void deleteUser(Integer userId){
        employeeRepository.deleteById(userId);
    }
    public ResponseEntity<List<EmployeeResponse>> getAllUsers(){
        try{
            List<EmployeeEntity> employeeEntities = findAllUsers();

            if (employeeEntities == null || employeeEntities.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<EmployeeResponse> employeeResponse = Utility.copyEmployeeResponse(employeeEntities);
            return ResponseEntity.ok(employeeResponse);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    public List<EmployeeEntity> findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }
    public List<EmployeeEntity> findByUserName(String userName){
        return employeeRepository.findByUserName(userName);
    }
    public List<EmployeeEntity> findByUserId(Integer userId){
        return employeeRepository.findByUserId(userId);
    }


    public ResponseEntity<String> assignTaskToEmployee(Integer userId, Integer taskId){
        try {
            EmployeeEntity employeeEntity = employeeRepository.findById(userId).orElse(null);
            TaskEntity taskEntity = taskRepository.findById(taskId).orElse(null);
            if (employeeEntity == null || taskEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee or Task not found");
            }
            employeeEntity.getTask().add(taskEntity);
            taskEntity.getEmployee().add(employeeEntity);

            employeeRepository.save(employeeEntity);
            taskRepository.save(taskEntity);

            return ResponseEntity.ok("Task assigned to Employee successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error assigning the task");
        }
    }

    public ResponseEntity<?> getTasksByEmloyee(Integer userId){
        EmployeeEntity employeeEntity = employeeRepository.findById(userId).orElse(null);
        if (employeeEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        List<TaskEntity> taskEntities = new ArrayList<>(employeeEntity.getTask());
            return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }


}
