package com.example.roleauthorizedemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    //role based autho
    @GetMapping("/hiUser")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String sayHiUser(){
        return "namaste all";
    }

    @GetMapping("/hiAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHiAdmin(){
        return "namaste admin";
    }

    //role based autho ends

    //role and permission based begins

    @GetMapping("/read")
    public String userRead(){
        return "user::read";
    }

    @PostMapping("/write")
    public String userWrite(){
        return "user::write";
    }

    @DeleteMapping("/delete")
    public String userDelete(){
        return "user::delete";
    }

    @GetMapping("/readAdmin")
    @PreAuthorize("hasAuthority('admin_read')")
    public String readAdmin(){
        return "admin::read";
    }

    @PostMapping("/writeAdmin")
    @PreAuthorize("hasAuthority('admin_write')")
    public String writeAdmin(){
        return "admin::write";
    }

    @DeleteMapping("/deleteAdmin")
    @PreAuthorize("hasAuthority('admin_delete')")
    public String deleteAdmin(){
        return "admin::delete";
    }

    //role and permission based ends

}
