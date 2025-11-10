package com.example.demo.service;

import com.example.demo.model.ProjectEntity;
import com.example.demo.repositoty.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }
    public List<ProjectEntity> findByProjectDescription(String projectDescription) {
        return projectRepository.findByProjectDescription(projectDescription);
    }
    public List<ProjectEntity> findByProjectId(Integer projectId) {
        return projectRepository.findByProjectId(projectId);
    }
    public List<ProjectEntity> findByProjectName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

}
