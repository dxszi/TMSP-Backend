package com.example.demo.service;

import com.example.demo.model.PermissionEntity;
import com.example.demo.model.RoleEntity;
import com.example.demo.repositoty.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleEntity> findAllProjects() {
        return roleRepository.findAll();
    }
    public List<RoleEntity> saveRole(List<RoleEntity> roleEntities) {
        return roleRepository.saveAll(roleEntities);
    }
    public void deleteRole(RoleEntity roleEntity) {
        roleRepository.delete(roleEntity);
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
