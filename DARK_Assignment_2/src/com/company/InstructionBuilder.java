package com.company;

import com.company.Enums.OpCodes;
import com.company.Exceptions.NotValidInstructionException;
import com.company.Instructions.*;

/**
 * Created by c13vzs on 2016-11-14.
 */
public class InstructionBuilder {

    private enum instructionType{
        R,
        I,
        J,
        JR,
        B,
        NONE
    }

    private InstructionBuilder() {

    }

    public static Instruction getInstructionFromMnemonic(String instruction) {
        //TODO: Decode a string of memnomic instruction
        String iv[] = instruction.split(" ");
        if(OpCodes.fromAbbr(iv[0]) != OpCodes.NONE) {
        }
        return null;
    }

    public static Instruction getInstructionFromNumeric(String instruction) throws NotValidInstructionException {
        long value = Long.decode(instruction);
        switch (getType(value)) {
            case R:
                return new RInstruction(instruction);
            case I:
                return new IInstruction(instruction);
            case J:
                return new JInstruction(instruction);
            case JR:
                return new JRInstruction(instruction);
            case B:
                return new BInstruction(instruction);
            case NONE:
                return null;
            default:
                throw new NotValidInstructionException("Input not a valid instruction");
        }
    }

    private static instructionType getType()

    private static instructionType getType(long value) {
        long op = Instruction.getXBits(value,6,32);
        long funct = Instruction.getXBits(value,6,6);

        //If op is 0 or 28 its of the type R
        if(op == 0 || op == 28) {
            //If the funct is 8 or 9 then its a jump (JR)
            if (funct == 8 || funct == 9) {
                return instructionType.JR;
            } else {
                return instructionType.R;
            }
        //If op is 1 the type depends on the RT-field
        } else if (op == 1) {
            long rt = Instruction.getXBits(value,5,16);
            //If rt is any of these its an branch instruction
            if((rt >= 0 && rt <= 3) || (rt >= 16 && rt <= 19)) {
                return instructionType.B;
            //Else it's an I instruction
            } else {
                return instructionType.I;
            }
        } else if (op == 2 || op == 3) {
            //Only J if op is 2 or 3
            return instructionType.J;
        } else if ((op >= 4 && op <= 7) || (op >= 20 && op <= 23)) {
            return instructionType.B;
        } else if (OpCodes.fromValue(op) != OpCodes.NONE) {
            return instructionType.I;
        } else {
            return instructionType.NONE;
        }
    }

}
