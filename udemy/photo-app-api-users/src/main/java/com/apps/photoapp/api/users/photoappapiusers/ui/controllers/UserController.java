package com.apps.photoapp.api.users.photoappapiusers.ui.controllers;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final Environment environment;

    public UserController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/status/check")
    public String status() {
        return "working on port: " + environment.getProperty("local.server.port");
    }

}
