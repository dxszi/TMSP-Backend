package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
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
    @Autowired
    private ProjectService projectService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

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
    public ResponseEntity<List<TaskResponse>>  findTaskByTaskId(@PathVariable Integer taskId){
        List<TaskEntity> taskEntities = taskService.findByTaskId(taskId);
        return ResponseEntity.ok(Utility.copyTaskResponse(taskEntities));
    }
    @GetMapping(path = ("/findTaskByStatusAndSubmittedBy/{status}/{submittedBy}"),produces = "application/json")
    public ResponseEntity<List<TaskResponse>> findTaskByStatusAndSubmittedBy(@PathVariable String status, @PathVariable String submittedBy){
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
    public void deleteUser(@PathVariable Integer userId){
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
    public ResponseEntity<List<EmployeeResponse>>  findByUserId(@PathVariable Integer userId){
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
    @PostMapping(path = "/addPrpject", produces = "application/json")
    public ResponseEntity<List<ProjectResponse>>  addPrpject(@RequestBody ProjectRequest projectRequest){
        List<ProjectEntity> projectEntities = Utility.copyProjectRequest(projectRequest);
        List<ProjectEntity> savedProjectEntities = projectService.saveProject(projectEntities);
        return ResponseEntity.ok(Utility.copyProjectResponse(savedProjectEntities));
    }
    @RequestMapping(path = "/getAllProjects", produces = "application/json")
    public ResponseEntity<List<ProjectResponse>> getAllProjects(){
        return  projectService.getAllProjects();
    }
    @GetMapping(path = ("/findProjectById/{projectId}"), produces = "application/json")
    public ResponseEntity<List<ProjectResponse>>  findProjectById(@PathVariable Integer projectId){
        List<ProjectEntity> projectEntities = projectService.findProjectById(projectId);
        return ResponseEntity.ok(Utility.copyProjectResponse(projectEntities));
    }
    @GetMapping(path = ("/findByProjectDescription/{projectDescription}"), produces = "application/json")
    public ResponseEntity<List<ProjectResponse>>  findByProjectDescription(@PathVariable String projectDescription){
        List<ProjectEntity> projectEntities = projectService.findByProjectDescription(projectDescription);
        return ResponseEntity.ok(Utility.copyProjectResponse(projectEntities));
    }
    @GetMapping(path = "/findByProjectName/{projectName}", produces = "application/json")
    public ResponseEntity<List<ProjectResponse>>  findByProjectName(@PathVariable String projectName){
        List<ProjectEntity> projectEntities = projectService.findByProjectName(projectName);
        return ResponseEntity.ok(Utility.copyProjectResponse(projectEntities));
    }
    @DeleteMapping(path = "/deleteProject/{projectId}", produces = "application/json")
    public void deleteProject(@PathVariable Integer projectId){
        projectService.deleteProject(projectId);
    }
    @RequestMapping(path = "/getAllRoles" , produces = "application/json")
    public ResponseEntity<List<RoleResponse>>  getAllRoles(){
        return roleService.getAllRoles();
    }
    @PostMapping(path = "/addRole", produces = "application/json")
    public ResponseEntity<List<RoleResponse>>  addRole(@RequestBody RoleRequest roleRequest){
        List<RoleEntity> roleEntities = Utility.copyRoleRequest(roleRequest);
        List<RoleEntity> savedRoleEntities = roleService.saveRole(roleEntities);
        return ResponseEntity.ok(Utility.copyRoleResponse(savedRoleEntities));
    }
    @GetMapping(path = ("/findRoleByRoleId/{roleId}"), produces = "application/json")
    public ResponseEntity<List<RoleResponse>>  findRoleByRoleId(@PathVariable Integer roleId){
        List<RoleEntity> roleEntities = roleService.findByRoleId(roleId);
        return ResponseEntity.ok(Utility.copyRoleResponse(roleEntities));
    }
    @GetMapping(path = ("/findByRoleName/{roleName}"),produces = "application/json")
    public ResponseEntity<List<RoleResponse>>  findByRoleName(@PathVariable String roleName){
        List<RoleEntity> roleEntities = roleService.findByRoleName(roleName);
        return ResponseEntity.ok(Utility.copyRoleResponse(roleEntities));
    }
    @RequestMapping(path = "/getAllPermissions", produces = "application/json")
    public ResponseEntity<List<PermissionResponse>>  getAllPermissions(){
        return permissionService.getAllPermissions();
    }
    @GetMapping(path = "/findByPermissionId/{permissionId}", produces = "application/json")
    public ResponseEntity<List<PermissionResponse>>  findByPermissionId(@PathVariable Integer permissionId){
        List<PermissionEntity> permissionEntities = permissionService.findByPermissionId(permissionId);
        return ResponseEntity.ok(Utility.copyPermissionResponse(permissionEntities));
    }
    @GetMapping(path = "/findByPermissionName/{permissionName}", produces = "application/json")
    public ResponseEntity<List<PermissionResponse>>  findByPermissionName(@PathVariable String permissionName){
        List<PermissionEntity> permissionEntities = permissionService.findByPermissionName(permissionName);
        return ResponseEntity.ok(Utility.copyPermissionResponse(permissionEntities));
    }
    @PostMapping(path = "/addPermission", produces = "application/json")
    public ResponseEntity<List<PermissionResponse>>  addPermission(@RequestBody PermissionRequest permissionRequest){
        List<PermissionEntity> permissionEntities = Utility.copyPermissionRequest(permissionRequest);
        List<PermissionEntity> savedPermissionEntities = permissionService.savePermission(permissionEntities);
        return ResponseEntity.ok(Utility.copyPermissionResponse(savedPermissionEntities));
    }
    @DeleteMapping(path = "/deletePermission/{permissionId}" , produces = "application/json")
    public void deletePermission(@PathVariable Integer permissionId){
        permissionService.deletePermission(permissionId);
    }
}
