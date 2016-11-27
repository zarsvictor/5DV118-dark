package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-16.
 */
public enum Funct2 {

    MADD(0, "madd","R"),
    MADDU(1, "maddu","R"),
    MUL(2, "mul","R"),
    MSUB(4, "msub","R"),
    MSUBU(5, "msubu","R"),
    CLZ(32, "clz","R"),
    CLO(33, "clo","R"),
    NONE(-1,null, null);

    private final long value;
    private final String abbr;
    private final String type;

    Funct2(long value, String abbr, String type) {
        this.value = value;
        this.abbr = abbr;
        this.type = type;
    }

    public String getType() {
        return type;
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

    public static Funct2 fromAbbr(String abbr) {
        for (Funct2 funct : values()) {
            if (funct.getAbbr().equals(abbr)) {
                return funct;
            }
        }
        return NONE;
    }
}
