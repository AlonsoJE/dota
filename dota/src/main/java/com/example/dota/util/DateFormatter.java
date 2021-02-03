package com.example.dota.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {


    public static LocalDate fotmatDate(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(localDate.format(formatter));
    }

}
