package com.example.dota.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemFilter {

    private Long id;
    private String nameItem;
    private Double price;
    private String cooldown;
    private Integer moveSpeed;
    private Integer damage;
    private Integer inteligence;
    private Integer strenght;
    private Integer agility;
    private String createUser;
    private LocalDate createDate;
    private LocalDate createDateI;
    private LocalDate createDateF;
    private LocalDate updateDateI;
    private LocalDate updateDateF;
    private String updateUser;
    private LocalDate updateDate;

}
