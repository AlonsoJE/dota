package com.example.dota.resource;

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
    private HeroResource heroResource;
    private ItemResource itemResource;

}
