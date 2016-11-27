package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-16.
 */
public enum OpCodes {

    J(2, "j", "J"),
    JAL(3, "jal", "J"),
    BEQ(4, "beq","B"),
    BNE(5, "bne","B"),
    BLEZ(6, "blez","B"),
    BGTZ(7, "bgtz","B"),
    ADDI(8, "addi","I"),
    ADDIU(9, "addiu","I"),
    SLTI(10, "slti","I"),
    SLTIU(11, "sltiu","I"),
    ANDI(12, "andi","I"),
    ORI(13, "ori","I"),
    XORI(14, "xori","I"),
    LUI(15, "lui","I"),
    BEQL(20, "beql","I"),
    BNEL(21, "bnel","I"),
    BLEZL(22, "blezl","I"),
    BGTZL(23, "bgtzl","I"),
    LB(32, "lb","I"),
    LH(33, "lh","I"),
    LWL(34, "lwl","I"),
    LW(35, "lw","I"),
    LBU(36, "lbu","I"),
    LHU(37, "lhu","I"),
    LWR(38, "lwr","I"),
    SB(40, "sb","I"),
    SH(41, "sh","I"),
    SWL(42, "swl","I"),
    SW(43, "sw","I"),
    SWR(46, "swr","I"),
    CACHE(47, "cache","I"),
    LL(48, "ll","I"),
    LWC1(49, "lwc1","I"),
    LWC2(50, "lwc2","I"),
    PREF(51, "pref","I"),
    LDC1(53, "ldc1","I"),
    LDC2(54, "ldc2","I"),
    SC(56, "sc","I"),
    SWC1(57, "swc1","I"),
    SWC2(58, "swc2","I"),
    SDC1(61, "sdc1","I"),
    SDC2(62, "sdc2","I"),
    NONE(-1, null, null);

    private final long value;
    private final String abbr;
    private final String type;

    OpCodes(long value, String abbr, String type) {
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

    public static OpCodes fromValue(long value) {
        for (OpCodes op : values()) {
            if (op.getValue() == value) {
                return op;
            }
        }
        return NONE;
    }

    public static OpCodes fromAbbr(String abbr) {
        for (OpCodes op : values()) {
            if (op.getAbbr().equals(abbr)) {
                return op;
            }
        }
        return NONE;
    }
}
