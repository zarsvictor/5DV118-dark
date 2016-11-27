package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-16.
 */
public enum OpCodes {

    J(2, "j"),
    JAL(3, "jal"),
    BEQ(4, "beq"),
    BNE(5, "bne"),
    BLEZ(6, "blez"),
    BGTZ(7, "bgtz"),
    ADDI(8, "addi"),
    ADDIU(9, "addiu"),
    SLTI(10, "slti"),
    SLTIU(11, "sltiu"),
    ANDI(12, "andi"),
    ORI(13, "ori"),
    XORI(14, "xori"),
    LUI(15, "lui"),
    BEQL(20, "beql"),
    BNEL(21, "bnel"),
    BLEZL(22, "blezl"),
    BGTZL(23, "bgtzl"),
    LB(32, "lb"),
    LH(33, "lh"),
    LWL(34, "lwl"),
    LW(35, "lw"),
    LBU(36, "lbu"),
    LHU(37, "lhu"),
    LWR(38, "lwr"),
    SB(40, "sb"),
    SH(41, "sh"),
    SWL(42, "swl"),
    SW(43, "sw"),
    SWR(46, "swr"),
    CACHE(47, "cache"),
    LL(48, "ll"),
    LWC1(49, "lwc1"),
    LWC2(50, "lwc2"),
    PREF(51, "pref"),
    LDC1(53, "ldc1"),
    LDC2(54, "ldc2"),
    SC(56, "sc"),
    SWC1(57, "swc1"),
    SWC2(58, "swc2"),
    SDC1(61, "sdc1"),
    SDC2(62, "sdc2"),
    NONE(-1,null);

    private final long value;
    private final String abbr;

    OpCodes(long value, String abbr) {
        this.value = value;
        this.abbr = abbr;
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
}
