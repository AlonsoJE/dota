package com.example.dota.filter;

import com.example.dota.entity.HeroEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkinFilter {

    private Long id;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;
    private String style;
    private String createUser;
    private LocalDate createDate;
    private LocalDate createDateI;
    private LocalDate createDateF;
    private LocalDate updateDateI;
    private LocalDate updateDateF;
    private String updateUser;
    private LocalDate updateDate;


}
