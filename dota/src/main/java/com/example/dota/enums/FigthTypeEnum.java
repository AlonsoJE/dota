package com.example.dota.enums;

public enum FigthTypeEnum {

//    MELEE, RANGE

    MELEE(1, "Melee"), RANGE(2, "Range");


    public int getI() {
        return i;
    }

    public String getDescription() {
        return description;
    }

    private final int i;
    private final String description;

    FigthTypeEnum(int i, String melee) {
        this.i = i;
        this.description = melee;
    }


}
