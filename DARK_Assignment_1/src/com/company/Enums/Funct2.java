package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-16.
 */
public enum Funct2 {

    MADD(0, "madd"),
    MADDU(1, "maddu"),
    MUL(2, "mul"),
    MSUB(4, "msub"),
    MSUBU(5, "msubu"),
    CLZ(32, "clz"),
    CLO(33, "clo"),
    NONE(-1,null);

    private final long value;
    private final String abbr;

    Funct2(long value, String abbr) {
        this.value = value;
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

    public long getValue() {
        return value;
    }

    public static Funct2 fromValue(long value) {
        for (Funct2 abbr : values()) {
            if (abbr.getValue() == value) {
                return abbr;
            }
        }
        return NONE;
    }

}
