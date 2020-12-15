package com.example.dota.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NotFoundException extends RuntimeException {

    private String message;

}
