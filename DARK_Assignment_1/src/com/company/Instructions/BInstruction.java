package com.company.Instructions;

/**
 * Created by c13vzs on 2016-11-23.
 */
public class BInstruction extends IInstruction {

    public BInstruction(String instruction) {
        super(instruction);
        type = "B";
        immediate += 1;
        abbr = abbrOp +  ", " + abbrRt + ", " + abbrRs + ", " + immediate;
        comment = "the target is " + immediate + " instructions below";
    }

}
