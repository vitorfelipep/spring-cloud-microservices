package com.app.accountmanager.microservice.accountmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagerApplication.class, args);
    }

}
