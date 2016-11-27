package com.company.Instructions;

import com.company.Enums.Funct1;
import com.company.Enums.Funct2;
import com.company.Enums.Registers;
import com.company.Exceptions.NotValidInstructionException;

/**
 * Created by c13vzs on 2016-11-17.
 */
public class JRInstruction extends Instruction{
    private long op;
    private long rs;
    private long rt;
    private long rd;
    private long shamt;
    private long funct;
    private String abbrOp;
    private String abbrRd;
    private String abbrRs;
    private String abbrRt;

    public JRInstruction(String instruction) throws NotValidInstructionException {
        this.instruction = instruction;
        value = Long.decode(instruction);
        comment = "";
        op = getXBits(value,6,32);
        rs = getXBits(value, 5, 26);
        rt = getXBits(value, 5, 21);
        rd = getXBits(value, 5, 16);
        shamt = getXBits(value, 5, 11);
        if(shamt != 0) {
            //Should be 0?
            //throw new NotValidInstructionException("Not a valid R-instruction");
        }
        funct = getXBits(value, 6, 6);
        type = "JR";
        decomp = "[" + op + " " + rs + " " + rt + " " + rd + " " + shamt + " " + funct + "]";
        decompHex = "[" + Long.toHexString(op) + " " + Long.toHexString(rs) + " " + Long.toHexString(rt) +
                " " + Long.toHexString(rd) + " " + Long.toHexString(shamt) + " " + Long.toHexString(funct) + "]";
        abbrRd = Registers.getAbbrFromValue(rd);
        abbrRs = Registers.getAbbrFromValue(rs);
        abbrRt = Registers.getAbbrFromValue(rt);
        if(op != 28) {
            abbrOp = Funct1.fromValue(funct).getAbbr();
        } else {
            abbrOp = Funct2.fromValue(funct).getAbbr();
        }
        abbr = abbrOp +  ", " + abbrRs + ", " + abbrRt+ ", " + abbrRd;
        if(rs == 0) {
            abbr = abbr.replace(", " + abbrRs,"");
        }
        if(rt == 0) {
            abbr = abbr.replace(", " + abbrRt, "");
        }
        if(rd == 0) {
            abbr = abbr.replace(", " + abbrRd, "");
        }
    }
}
