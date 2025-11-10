package com.example.demo.repositoty;

import com.example.demo.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    List<RoleEntity> findByRoleId(Integer roleId);
    List<RoleEntity> findByRoleName(String roleName);
}
