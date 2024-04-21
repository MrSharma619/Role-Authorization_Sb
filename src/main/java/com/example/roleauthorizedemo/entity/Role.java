package com.example.roleauthorizedemo.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public enum Role {
    USER(
            Set.of(Permission.USER_READ,
                    Permission.USER_WRITE,
                    Permission.USER_DELETE)
    ),
    ADMIN(
            Set.of(Permission.USER_READ,
                    Permission.USER_WRITE,
                    Permission.USER_DELETE,
                    Permission.ADMIN_READ,
                    Permission.ADMIN_WRITE)
    ),

    SENIOR_ADMIN(
            Set.of(Permission.USER_READ,
            Permission.USER_WRITE,
            Permission.USER_DELETE,
            Permission.ADMIN_READ,
            Permission.ADMIN_WRITE,
            Permission.ADMIN_DELETE)
    );


    private Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = new ArrayList<>(getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }

}
