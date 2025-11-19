package com.example.demo.service;

import com.example.demo.model.ProjectEntity;
import com.example.demo.model.ProjectResponse;
import com.example.demo.repositoty.ProjectRepository;
import com.example.demo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectEntity> saveProject(List<ProjectEntity> projectEntities) {
        return projectRepository.saveAll(projectEntities);
    }
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        try {
            List<ProjectEntity> projectEntities = findAllProjects();

            if (projectEntities == null || projectEntities.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<ProjectResponse> projectResponse = Utility.copyProjectResponse(projectEntities);
            return ResponseEntity.ok(projectResponse);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    public List<ProjectEntity> findProjectById( Integer projectId){
        return projectRepository.findByProjectId(projectId);
    }
    public List<ProjectEntity> findByProjectDescription(String projectDescription) {
        return projectRepository.findByProjectDescription(projectDescription);
    }
//    public List<ProjectEntity> findByProjectId(Integer projectId) {
//        return projectRepository.findByProjectId(projectId);
//    }
    public List<ProjectEntity> findByProjectName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}
