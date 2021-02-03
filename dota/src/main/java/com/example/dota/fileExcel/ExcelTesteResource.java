package com.example.dota.fileExcel;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ExcelTesteResource {

    private LocalDate data;
    private String name;
    private BigDecimal valor = BigDecimal.ZERO;
    private String status;
    private int parcela;
    private BigDecimal total = BigDecimal.ZERO;


}
