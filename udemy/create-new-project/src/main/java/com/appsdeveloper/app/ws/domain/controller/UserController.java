package com.appsdeveloper.app.ws.domain.controller;

import com.appsdeveloper.app.ws.domain.dto.UserDTO;
import com.appsdeveloper.app.ws.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<UserDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit
    ) {
        return userService.findAll(page, limit);
    }

    @GetMapping(value = "/{key}", produces = "application/json")
    public ResponseEntity<UserDTO> findByKey(@PathVariable String key) {
        return userService.findByKey(key);
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping(value = "/{key}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<UserDTO> update(@PathVariable String key, @RequestBody UserDTO userDTO) {
        return userService.update(key, userDTO);
    }

    @DeleteMapping(path = "/{key}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String key) {
        userService.delete(key);
    }
}
