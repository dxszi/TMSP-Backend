package com.example.demo.repositoty;

import com.example.demo.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <TaskEntity, Integer> {
    List<TaskEntity> findByTitle(String title);
    List<TaskEntity> findByStatus(String status);
    List<TaskEntity> findBySubmittedBy(String submittedBy);
    List<TaskEntity> findByTaskId(Integer taskId);
    List<TaskEntity> findByStatusAndSubmittedBy(String status, String submittedBy);
    List<TaskEntity> findByPriority(String priority);
}
