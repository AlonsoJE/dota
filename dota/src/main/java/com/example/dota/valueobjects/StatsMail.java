package com.example.dota.valueobjects;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StatsMail {

    private String destiny;
    private String subject;
    private String messageBody;

}
