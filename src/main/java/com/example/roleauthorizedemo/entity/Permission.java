package com.example.roleauthorizedemo.entity;

public enum Permission {
    ADMIN_READ("admin_read"),
    ADMIN_WRITE("admin_write"),
    ADMIN_DELETE("admin_delete"),

    USER_READ("user_read"),
    USER_WRITE("user_write"),
    USER_DELETE("user_delete");


    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
