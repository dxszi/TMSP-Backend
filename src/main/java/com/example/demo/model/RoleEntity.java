package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Role")
public class RoleEntity {
    @Id
    @Column(name = "Role_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name ="Role_Name", nullable=false)
    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "Role_ID"),
            inverseJoinColumns = @JoinColumn(name = "Permission_ID"))
    private Set<PermissionEntity> permission =new HashSet<>();
}
