package com.company.Instructions;

import com.company.Enums.OpCodes;

/**
 * Created by c13vzs on 2016-11-14.
 */
public class JInstruction extends Instruction {

    private long op;
    private long target;
    private String abbrOp;

    public JInstruction(String instruction) {
        this.instruction = instruction;
        value = Long.decode(instruction);
        comment = "";
        type = "J";
        op = getXBits(value,6,32);
        target = getXBits(value, 26, 26);
        decomp = "[" + op + " " + target + "]";
        decompHex = "[" + Long.toHexString(op) + " " + Long.toHexString(target) + "]";
        abbrOp = OpCodes.fromValue(op).getAbbr();
        abbr = abbrOp + ", " + Long.toHexString(getXBits(target,24,24));
    }

    public JInstruction() {
    }

    public long getOp() {
        return op;
    }

    public void setOp(long op) {
        this.op = op;
    }

    public long getTarget() {
        return target;
    }

    public void setTarget(long target) {
        this.target = target;
    }

    public String getAbbrOp() {
        return abbrOp;
    }

    public void setAbbrOp(String abbrOp) {
        this.abbrOp = abbrOp;
    }
}
