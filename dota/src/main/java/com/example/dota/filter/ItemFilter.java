package com.example.dota.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
