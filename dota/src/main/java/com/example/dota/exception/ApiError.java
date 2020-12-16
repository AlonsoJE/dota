package com.example.dota.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private int status;
    private LocalDateTime timestamp;
    private String exception;
    private String cause;
    private String devMessage;
    private String userMessage;


}
