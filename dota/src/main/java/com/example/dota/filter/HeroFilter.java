package com.example.dota.filter;

import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroFilter {

    private Long id;
    private String nameHero;
    private String nickNameHero;
    private String realName;
    private FigthTypeEnum figthTypeEnum;
    private ClassTypeEnum classTypeEnum;
    private String createUser;
    private LocalDate createDate;
    private LocalDate createDateI;
    private LocalDate createDateF;
    private LocalDate updateDateI;
    private LocalDate updateDateF;
    private String updateUser;
    private LocalDate updateDate;

}
