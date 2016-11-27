package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-23.
 */
public enum RtCodes {
    BLTZ(32, "bltz"),
    BGEZ(33, "bgez"),
    BLTZL(34, "bltzl"),
    BGEZL(35, "bgezl"),
    TGEI(36, "tgei"),
    TGEIU(37, "tgeiu"),
    TLTI(38, "tlti"),
    TLTIU(40, "tltiu"),
    TEGI(41, "tegi"),
    TNEI(42, "tnei"),
    BLTZAL(43, "bltzal"),
    BGEZAL(46, "bgezal"),
    BLTZALL(47, "bltzall"),
    BGCZALL(48, "bgczall"),
    NONE(-1,null);

    private final long value;
    private final String abbr;

    RtCodes(long value, String abbr) {
        this.value = value;
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

    public long getValue() {
        return value;
    }

    public static RtCodes fromValue(long value) {
        for (RtCodes op : values()) {
            if (op.getValue() == value) {
                return op;
            }
        }
        return NONE;
    }
}
