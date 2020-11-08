package com.app.accountmanager.microservice.accountmanager.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @GetMapping("/status/check")
    public String status() {
        return "working...";
    }

}
