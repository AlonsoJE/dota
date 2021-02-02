package com.example.dota.resource;

import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class HeroResource {

    private Long id;
    private String nameHero;
    private String nickNameHero;
    private String realName;
    private FigthTypeEnum figthTypeEnum;
    private ClassTypeEnum classTypeEnum;
    private String createUser;
    private String updateUser;
    private LocalDate createDate;
    private LocalDate updateDate;
    private CurrierResource currier;
    @JsonIgnoreProperties(value = "hero")
    private List<SkinResource> skin;
    @JsonIgnoreProperties(value = "hero")
    private List<ItemHeroResource> itemHero;

}
