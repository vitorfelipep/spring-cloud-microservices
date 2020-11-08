package com.appsdeveloper.app.ws.exceptions.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private LocalDate timestamp;
    private String message;

}
