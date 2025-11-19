package com.example.demo.model;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;

}
