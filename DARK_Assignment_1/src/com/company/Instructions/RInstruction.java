package com.company.Instructions;

import com.company.Enums.Funct1;
import com.company.Enums.Funct2;
import com.company.Enums.Registers;
import com.company.Exceptions.NotValidInstructionException;

/**
 * Created by c13vzs on 2016-11-14.
 */
public class RInstruction extends Instruction {

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
    private String abbrShamt;

    public RInstruction(String instruction) throws NotValidInstructionException {
        this.instruction = instruction;
        value = Long.decode(instruction);
        comment = "";
        //Get the OP-bits
        op = getXBits(value,6,32);
        //Get the rs-bits
        rs = getXBits(value, 5, 26);
        //Get the Rt-bits
        rt = getXBits(value, 5, 21);
        //Get the rd-bits
        rd = getXBits(value, 5, 16);
        //Get the shamt-bits
        shamt = getXBits(value, 5, 11);
        //Shamt has to be 0 in an R-instruction
        if(shamt != 0) {
            comment = "shamt must be 0 but was " + shamt;
        }

        //Get the funct-bits
        funct = getXBits(value, 6, 6);
        type = "R";
        //Make a pretty string to print as Decomposiiton as decimal
        decomp = "[" + op + " " + rs + " " + rt + " " + rd + " " + shamt + " " + funct + "]";
        //Make a pretty string to print as Decomposition as hexadecimal
        decompHex = "[" + Long.toHexString(op) + " " + Long.toHexString(rs) + " " + Long.toHexString(rt) +
                " " + Long.toHexString(rd) + " " + Long.toHexString(shamt) + " " + Long.toHexString(funct) + "]";

        //Fetch the register abbreviation for rd
        abbrRd = Registers.getAbbrFromValue(rd);
        //Fetch the register abbreviation for rs
        abbrRs = Registers.getAbbrFromValue(rs);
        //Fetch the register abbreviation for Rt
        abbrRt = Registers.getAbbrFromValue(rt);
        if(op != 28) {
            abbrOp = Funct1.fromValue(funct).getAbbr();
        } else {
            abbrOp = Funct2.fromValue(funct).getAbbr();
        }
        abbr = abbrOp +  ", " + abbrRd + ", " + abbrRs+ ", " + abbrRt;

    }
}
