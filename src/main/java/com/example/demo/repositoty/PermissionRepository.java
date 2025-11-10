package com.example.demo.repositoty;

import com.example.demo.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<PermissionEntity,Integer>
{
    List<PermissionEntity> findByPermissionId(Integer permissionId);
    List<PermissionEntity> findByPermissionName(String permissionName);

}
