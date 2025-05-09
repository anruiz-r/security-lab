package com.example.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class BasicControllers {

    @RestController
    @RequestMapping("/api/public")
    public class PublicController {

        @GetMapping("/hello")
        public String hello() {
            return "Hello! This is a public endpoint.";
        }
    }

    @RestController
    @RequestMapping("/api/user")
    public class UserController {

        @GetMapping("/profile")
        public String profile(Authentication authentication) {
            return "User profile: " + authentication.getName();
        }
    }

    @RestController
    @RequestMapping("/api/admin")
    public class AdminController {

        @GetMapping("/users")
        public String listUsers() {
            return "User listing (only accessible by administrators)";
        }
    }
}
