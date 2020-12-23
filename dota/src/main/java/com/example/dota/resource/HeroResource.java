package com.example.dota.resource;

import com.example.dota.entity.CurrierEntity;
import com.example.dota.entity.ItemEntity;
import com.example.dota.entity.SkinEntity;
import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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
    private CurrierEntity currier;
    private List<SkinEntity> skins;
    private List<ItemEntity> item;

}
