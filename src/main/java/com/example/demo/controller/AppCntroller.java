package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.TaskService;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@Slf4j
public class AppCntroller {

    @Autowired
    private TaskService taskService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/getAllTasks", produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  getAllTasks(){
        return  taskService.getAllTasks();
    }
    @PostMapping(path = "/addTasks", produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  addTasks(@RequestBody TaskRequest taskRequest){
        List<TaskEntity> taskEntities = Utility.copyTaskRequest(taskRequest);
        List<TaskEntity> savedTaskEntities = taskService.saveTask(taskEntities);
        return ResponseEntity.ok(Utility.copyTaskResponse(savedTaskEntities));
    }
    @DeleteMapping("/deleteTask/{taskId}")
    public void deleteTask(@PathVariable int taskId){
        taskService.deleteTask(taskId);
    }
    @GetMapping(path = ("/findTaskByTitle/{title}"),produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  findTaskByTitle(@PathVariable String title){
        List<TaskEntity> taskEntities = taskService.findByTitle(title);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @GetMapping(path = ("/findTaskByStatus/{status}"), produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  findTaskByStatus(@PathVariable String status){
        List<TaskEntity> taskEntities = taskService.findByStatus(status);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @GetMapping(path= ("/findTaskByPriority/{priority}"), produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  findTaskByPriority(@PathVariable String priority){
        List<TaskEntity> taskEntities = taskService.findByPriority(priority);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @GetMapping(path = ("/findTaskBySubmittedBy/{submittedBy}"),produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  findTaskBySubmittedBy(@PathVariable String submittedBy){
        List<TaskEntity> taskEntities = taskService.findBySubmittedBy(submittedBy);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @GetMapping(path = ("/findTaskByTaskId/{taskId}"),produces = "application/json")
    public ResponseEntity<List<TaskResponse>>  findTaskByTaskId(@PathVariable int taskId){
        List<TaskEntity> taskEntities = taskService.findByTaskId(taskId);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @GetMapping(path = ("/findTaskByStatusAndSubmittedBy/{status}/{submittedBy}"),produces = "application/json")
    public ResponseEntity<List<TaskResponse>> findTaskByStatusAnsSubmittedBy(@PathVariable String status, @PathVariable String submittedBy){
        List<TaskEntity> taskEntities = taskService.findByStatusAndSubmittedBy(status, submittedBy);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @RequestMapping(path = "/getAllUsers", produces = "application/json")
    public ResponseEntity<List<EmployeeResponse>> getAllUsers(){
        return  employeeService.getAllUsers();
    }
    @PostMapping(path = "/addUsers", produces = "application/json")
    public ResponseEntity<List<EmployeeResponse>> addUsers(@RequestBody EmployeeRequest employeeRequest){
        List<EmployeeEntity> employeeEntities = Utility.copyEmployeeRequest(employeeRequest);
        List<EmployeeEntity> savedEmployeeEntities = employeeService.saveUser(employeeEntities);
        return ResponseEntity.ok(Utility.copyEmployeeResponse(savedEmployeeEntities));
    }
    @DeleteMapping("deleteUser/{userId}")
    public void deleteUser(@PathVariable int userId){
        employeeService.deleteUser(userId);
    }
    @GetMapping(path = ("/findUserByEmail/{email}"), produces = "application/json")
    public ResponseEntity<List<EmployeeResponse>> findByEmail(@PathVariable String email){
        List<EmployeeEntity> employeeEntities = employeeService.findByEmail(email);
        return ResponseEntity.ok(Utility.copyEmployeeResponse(employeeEntities));
    }

    @GetMapping(path = ("/findUserByUserName/{userName}"), produces = "application/json")
    public ResponseEntity<List<EmployeeResponse>> findByUserName(@PathVariable String userName){
        List<EmployeeEntity> employeeEntities = employeeService.findByUserName(userName);
        return ResponseEntity.ok(Utility.copyEmployeeResponse(employeeEntities));
    }
    @GetMapping(path = ("/findUserByUserId/{userId}"), produces = "application/json")
    public ResponseEntity<List<EmployeeResponse>>  findByUserId(@PathVariable int userId){
        List<EmployeeEntity> employeeEntities = employeeService.findByUserId(userId);
        return ResponseEntity.ok(Utility.copyEmployeeResponse(employeeEntities));
    }
    @PostMapping(path = ("/assignTask/{userId}/{taskId}"), produces = "application/json")
    public ResponseEntity<String> assignTaskToEmployee(@PathVariable Integer userId, @PathVariable Integer taskId){
        return  employeeService.assignTaskToEmployee(userId, taskId);
    }
    @GetMapping(path = ("/getTaskByEmployee/{userId}"), produces = "application/json")
    public ResponseEntity<?>  getTaskByEmployee(@PathVariable Integer userId){
        return employeeService.getTasksByEmloyee(userId);
    }
    @GetMapping(path = ("/getEmployeesByTask/{taskId}"), produces = "application/json")
    public ResponseEntity<?>  getEmployeesByTask(@PathVariable Integer taskId){
        return taskService.getEmployeesByTaskId(taskId);
    }
}
