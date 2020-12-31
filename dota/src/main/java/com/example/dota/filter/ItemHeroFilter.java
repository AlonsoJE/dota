package com.example.dota.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemHeroFilter {

    private Long id;
    private String createUser;
    private LocalDate createDate;
    private LocalDate createDateI;
    private LocalDate createDateF;
    private LocalDate updateDateI;
    private LocalDate updateDateF;
    private String updateUser;
    private LocalDate updateDate;

}
