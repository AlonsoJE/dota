package com.example.dota.valueobjects;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StatsItemResource {

    private BigDecimal totalAmount = BigDecimal.ZERO;
    private Integer totalMoveSpeed;
    private Integer totalDamage;
    private Integer totalInteligence;
    private Integer totalStrenght;
    private Integer totalAgility;

}
