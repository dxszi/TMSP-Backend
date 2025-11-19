package com.example.demo.service;

import com.example.demo.model.PermissionEntity;
import com.example.demo.model.RoleEntity;
import com.example.demo.model.RoleResponse;
import com.example.demo.repositoty.RoleRepository;
import com.example.demo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleEntity> findAllRoles() {
        return roleRepository.findAll();
    }
    public ResponseEntity<List<RoleResponse>> getAllRoles(){
        try {
            List<RoleEntity> roleEntities = findAllRoles();

            if (roleEntities == null || roleEntities.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<RoleResponse> roleResponse = Utility.copyRoleResponse(roleEntities);
            return ResponseEntity.ok(roleResponse);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    public List<RoleEntity> saveRole(List<RoleEntity> roleEntities) {
        return roleRepository.saveAll(roleEntities);
    }
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
    public List<RoleEntity> findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
    public List<RoleEntity> findByRoleId(Integer roleId) {
        return roleRepository.findByRoleId(roleId);
    }
    public List<PermissionEntity> getPermissionByRoleId(Integer roleId) {
        RoleEntity role = roleRepository.findById(roleId).orElse(null);

        if (role == null) {
            return null;
        }
        return new ArrayList<>(role.getPermission());
    }
}
