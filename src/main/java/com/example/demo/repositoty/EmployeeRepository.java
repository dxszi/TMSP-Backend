package com.example.demo.repositoty;

import com.example.demo.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findByUserId(Integer userId);
    List<EmployeeEntity> findByUserName(String userName);
    List<EmployeeEntity> findByEmail(String email);
}
