package com.example.roleauthorizedemo.dto;


import com.example.roleauthorizedemo.entity.Role;

public class RegisterDto {
    private String name;

    private String email;

    private String password;

    private Role role;

    public RegisterDto(String name, String email, String password, Role role) {
  //public RegisterDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
