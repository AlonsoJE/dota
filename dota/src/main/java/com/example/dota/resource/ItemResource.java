package com.example.dota.resource;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemResource {

    private Long id;
    private String nameItem;
    private String about;
    private BigDecimal price = BigDecimal.ZERO;
    private Double cooldown;
    private String actionItem;
    private Integer moveSpeed;
    private Integer damage;
    private Integer inteligence;
    private Integer strenght;
    private Integer agility;
    private String createUser;
    private LocalDate createDate;
    private String updateUser;
    private LocalDate updateDate;
    private List<ItemHeroResource> itemHeroResources;
}
