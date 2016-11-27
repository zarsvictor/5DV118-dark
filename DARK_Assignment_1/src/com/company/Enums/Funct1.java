package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-16.
 */
public enum Funct1 {
    SLL(0, "sll"),
    SRL(2, "srl"),
    SRA(3, "sra"),
    SLLV(4, "sllv"),
    SRLV(6, "srlv"),
    SRAV(7, "srav"),
    JR(8, "jr"),
    JALR(9, "jalr"),
    MOVZ(10, "movz"),
    MOVN(11, "movn"),
    SYSCALL(12, "syscall"),
    BREAK(13, "break"),
    SYNC(15, "sync"),
    MFHI(16, "mfhi"),
    MTHI(17, "mthi"),
    MFLO(18, "mflo"),
    MTLO(19, "mtlo"),
    MULT(24, "mult"),
    MULTU(25, "multu"),
    DIV(26, "div"),
    DIVU(27, "divu"),
    ADD(32, "add"),
    ADDU(33, "addu"),
    SUB(34, "sub"),
    SUBU(35, "subu"),
    AND(36, "and"),
    OR(37, "or"),
    XOR(38, "xor"),
    NOR(29, "nor"),
    SLT(42, "slt"),
    SLTU(43, "sltu"),
    TGE(48, "tge"),
    TGEU(49, "tgeu"),
    TLT(50, "tlt"),
    TLTU(51, "tltu"),
    TEQ(52, "teq"),
    TNE(54, "tne"),
    NONE(-1,null);

    private final long value;
    private final String abbr;

    Funct1(long value, String abbr) {
        this.value = value;
        this.abbr = abbr;
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
}
