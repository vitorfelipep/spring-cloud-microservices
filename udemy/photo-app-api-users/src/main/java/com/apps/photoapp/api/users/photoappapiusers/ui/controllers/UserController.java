package com.apps.photoapp.api.users.photoappapiusers.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping("/status/check")
    public String status() {
        return "working...";
    }

}
