package com.example.dota.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemHeroResource {

    private Long id;
    private String createUser;
    private String updateUser;
    private LocalDate createDate;
    private LocalDate updateDate;
    @JsonIgnoreProperties(value = {"currier", "skin", "itemHero"})
    private HeroResource hero;
    private ItemResource item;

}
