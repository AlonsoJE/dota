package com.example.dota.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroFilter {

    private Long id;
    private String nameHero;
    private String nickNameHero;
    private String realName;
    private String figthType;
    private String classType;
    private String createUser;
    private LocalDate createDate;
    private String updateUser;
    private LocalDate updateDate;

}
