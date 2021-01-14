package com.example.dota.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(value = {"currier","skin"})
    private HeroResource hero;

}
