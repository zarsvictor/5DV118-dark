package com.company.Instructions;

import com.company.Enums.OpCodes;
import com.company.Enums.Registers;

/**
 * Created by c13vzs on 2016-11-14.
 */
public class IInstruction extends Instruction {

    protected long op;
    protected long rs;
    protected long rt;
    protected short immediate;
    protected String abbrOp;
    protected String abbrRs;
    protected String abbrRt;

    public IInstruction(String instruction) {
        this.instruction = instruction;
        value = Long.decode(instruction);
        comment = "";
        type = "I";
        op = getXBits(value,6,32);
        rs = getXBits(value, 5, 26);
        rt = getXBits(value, 5, 21);
        immediate = (short)getXBits(value,16,16);
        decomp = "[" + op + " " + rs + " " + rt + " " + immediate + "]";
        decompHex = "[" + Long.toHexString(op) + " " + Long.toHexString(rs) + " " + Long.toHexString(rt) +
                " " + Integer.toHexString(immediate & 0xf) + "]";

        abbrOp = OpCodes.fromValue(op).getAbbr();
        abbrRs = Registers.getAbbrFromValue(rs);
        abbrRt = Registers.getAbbrFromValue(rt);
        abbr = abbrOp +  ", " + abbrRt + ", " + abbrRs + ", " + immediate;
    }

    public IInstruction() {
    }

    public long getOp() {
        return op;
    }

    public void setOp(long op) {
        this.op = op;
    }

    public long getRs() {
        return rs;
    }

    public void setRs(long rs) {
        this.rs = rs;
    }

    public long getRt() {
        return rt;
    }

    public void setRt(long rt) {
        this.rt = rt;
    }

    public short getImmediate() {
        return immediate;
    }

    public void setImmediate(short immediate) {
        this.immediate = immediate;
    }

    public String getAbbrOp() {
        return abbrOp;
    }

    public void setAbbrOp(String abbrOp) {
        this.abbrOp = abbrOp;
    }

    public String getAbbrRs() {
        return abbrRs;
    }

    public void setAbbrRs(String abbrRs) {
        this.abbrRs = abbrRs;
    }

    public String getAbbrRt() {
        return abbrRt;
    }

    public void setAbbrRt(String abbrRt) {
        this.abbrRt = abbrRt;
    }
}
