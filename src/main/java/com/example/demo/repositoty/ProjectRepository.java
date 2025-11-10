package com.example.demo.repositoty;

import com.example.demo.model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {
    List<ProjectEntity> findByProjectStatus(String projectStatus);
    List<ProjectEntity> findByProjectName(String projectName);
    List<ProjectEntity> findByProjectDescription(String projectDescription);
    List<ProjectEntity> findByProjectId(Integer projectId);
}
