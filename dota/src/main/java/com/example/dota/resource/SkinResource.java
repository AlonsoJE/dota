package com.example.dota.resource;

import com.example.dota.entity.HeroEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SkinResource {


    private Long id;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;
    private String style;
    private String createUser;
    private LocalDate createDate;
    private String updateUser;
    private LocalDate updateDate;
    private HeroEntity hero;

}
