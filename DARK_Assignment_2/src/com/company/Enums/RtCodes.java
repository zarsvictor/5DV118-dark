package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-23.
 */
public enum RtCodes {
    BLTZ(32, "bltz","B"),
    BGEZ(33, "bgez","B"),
    BLTZL(34, "bltzl","B"),
    BGEZL(35, "bgezl","B"),
    TGEI(36, "tgei","I"),
    TGEIU(37, "tgeiu","I"),
    TLTI(38, "tlti","I"),
    TLTIU(40, "tltiu","I"),
    TEGI(41, "tegi","I"),
    TNEI(42, "tnei","I"),
    BLTZAL(43, "bltzal","B"),
    BGEZAL(46, "bgezal","B"),
    BLTZALL(47, "bltzall","B"),
    BGCZALL(48, "bgczall","B"),
    NONE(-1,null, null);

    private final long value;
    private final String abbr;
    private final String type;

    RtCodes(long value, String abbr, String type) {
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

    public static RtCodes fromValue(long value) {
        for (RtCodes op : values()) {
            if (op.getValue() == value) {
                return op;
            }
        }
        return NONE;
    }

    public static RtCodes fromAbbr(String abbr) {
        for (RtCodes rt : values()) {
            if (rt.getAbbr().equals(abbr)) {
                return rt;
            }
        }
        return NONE;
    }
}
