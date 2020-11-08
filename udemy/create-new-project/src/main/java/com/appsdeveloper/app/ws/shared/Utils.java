package com.appsdeveloper.app.ws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {

    public String generatedUUId() {
        return UUID.randomUUID().toString();
    }

}
