package com.apps.photoapp.api.users.photoappapiusers.ui.model.controllers;

import com.apps.photoapp.api.users.photoappapiusers.ui.model.dto.UserDTO;
import com.apps.photoapp.api.users.photoappapiusers.ui.model.service.UserService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final Environment environment;
    private UserService userService;

    public UserController(
            Environment environment,
            UserService userService
    ) {
        this.environment = environment;
        this.userService = userService;
    }

    @GetMapping("/status/check")
    public String status() {
        return "working on port: " + environment.getProperty("local.server.port");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

}
