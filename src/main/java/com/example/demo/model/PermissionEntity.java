package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Permission")
public class PermissionEntity {
    @Id
    @Column(name = "Permission_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;

    @Column(name = "Permission_Name")
    private String permissionName;

    @ManyToMany(mappedBy = "permission")
    private Set<RoleEntity> role =new HashSet<>();

}
