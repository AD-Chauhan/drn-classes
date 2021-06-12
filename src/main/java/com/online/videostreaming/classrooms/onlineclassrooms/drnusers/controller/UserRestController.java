package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.UserService;

@Validated
@RestController
public class UserRestController {


    private final UserService userService;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

   

   
}