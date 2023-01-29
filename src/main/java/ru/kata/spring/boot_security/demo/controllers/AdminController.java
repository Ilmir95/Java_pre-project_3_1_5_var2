package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Secured(value = {"ROLE_ADMIN"})
    @GetMapping
    public String findAll() {
        return "admin";
    }
}
