package com.example.demo.service;

import com.example.demo.model.PermissionEntity;
import com.example.demo.model.PermissionResponse;
import com.example.demo.model.RoleEntity;
import com.example.demo.repositoty.PermissionRepository;
import com.example.demo.repositoty.RoleRepository;
import com.example.demo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<PermissionEntity> savePermission(List<PermissionEntity> permissionEntities) {
        return permissionRepository.saveAll(permissionEntities);
    }

    public List<PermissionEntity> findAllPermissions() {
        return permissionRepository.findAll();
    }
    public ResponseEntity<List<PermissionResponse>> getAllPermissions() {
        try {
            List<PermissionEntity> permissionEntities = findAllPermissions();

            if (permissionEntities == null || permissionEntities.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<PermissionResponse> permissionResponse = Utility.copyPermissionResponse(permissionEntities);
            return ResponseEntity.ok(permissionResponse);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    public void deletePermission(Integer permissionId) {
        permissionRepository.deleteById(permissionId);
    }
    public List<PermissionEntity> findByPermissionId(Integer permissionId) {
        return permissionRepository.findByPermissionId(permissionId);
    }

    public List<PermissionEntity> findByPermissionName(String permissionName) {
        return permissionRepository.findByPermissionName(permissionName);
    }

    public String assignPermissionToRole(Integer permissionId, Integer roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElse(null);
        PermissionEntity permissionEntity = permissionRepository.findById(permissionId).orElse(null);

        if (roleEntity == null || permissionEntity == null) {
            return "Role or Permission Not Found";
        }
        roleEntity.getPermission().add(permissionEntity);
        roleRepository.save(roleEntity);

        return "Permission Assigned to Role successfully";
    }

    public List<RoleEntity> getRolesByPermissionId(Integer permissionId) {
        PermissionEntity permissionEntity = permissionRepository.findById(permissionId).orElse(null);
        if (permissionEntity == null) {
            return null;
        }
        return new ArrayList<>(permissionEntity.getRole());
    }
}