package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-16.
 */
public enum Funct1 {
    SLL(0, "sll","R"),
    SRL(2, "srl","R"),
    SRA(3, "sra","R"),
    SLLV(4, "sllv","R"),
    SRLV(6, "srlv","R"),
    SRAV(7, "srav","R"),
    JR(8, "jr","J"),
    JALR(9, "jalr","J"),
    MOVZ(10, "movz","R"),
    MOVN(11, "movn","R"),
    SYSCALL(12, "syscall","R"),
    BREAK(13, "break","R"),
    SYNC(15, "sync","R"),
    MFHI(16, "mfhi","R"),
    MTHI(17, "mthi","R"),
    MFLO(18, "mflo","R"),
    MTLO(19, "mtlo","R"),
    MULT(24, "mult","R"),
    MULTU(25, "multu","R"),
    DIV(26, "div","R"),
    DIVU(27, "divu","R"),
    ADD(32, "add","R"),
    ADDU(33, "addu","R"),
    SUB(34, "sub","R"),
    SUBU(35, "subu","R"),
    AND(36, "and","R"),
    OR(37, "or","R"),
    XOR(38, "xor","R"),
    NOR(29, "nor","R"),
    SLT(42, "slt","R"),
    SLTU(43, "sltu","R"),
    TGE(48, "tge","R"),
    TGEU(49, "tgeu","R"),
    TLT(50, "tlt","R"),
    TLTU(51, "tltu","R"),
    TEQ(52, "teq","R"),
    TNE(54, "tne","R"),
    NONE(-1,null, null);

    private final long value;
    private final String abbr;
    private final String type;

    Funct1(long value, String abbr, String type) {
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

    public static Funct1 fromValue(long value) {
        for (Funct1 abbr : values()) {
            if (abbr.getValue() == value) {
                return abbr;
            }
        }
        throw new IllegalArgumentException("No such level");
    }

    public static Funct1 fromAbbr(String abbr) {
        for (Funct1 funct : values()) {
            if (funct.getAbbr().equals(abbr)) {
                return funct;
            }
        }
        return NONE;
    }
}
