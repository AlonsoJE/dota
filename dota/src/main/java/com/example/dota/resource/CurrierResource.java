package com.example.dota.resource;

import com.example.dota.entity.HeroEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CurrierResource {

    private Long id;
    private String name;
    private String createUser;
    private LocalDate createDate;
    private String updateUser;
    private LocalDate updateDate;
    @JsonIgnoreProperties(value = "currier")
    private HeroEntity hero;

}