package com.company.Instructions;

/**
 * Created by c13vzs on 2016-11-14.
 */
public abstract class Instruction {


    protected String instruction;
    protected long value;
    protected String type;
    protected String decomp;
    protected String decompHex;
    protected String abbr;
    protected String comment;

    /**
     * isolate a run of nrOfBits bits in the middle of 'value' starting at
     * 'startBit' and pushes them as the most right bits
     *
     * @param value    The value with the bits
     * @param nrOfBits How many bits
     * @param startBit From which bit it should start
     * @return
     */
    public static long getXBits(long value, long nrOfBits, long startBit) {
        //Create a mask with the left nrOfBits is ones.
        long mask = ((1L << startBit) - 1L) >> (startBit - nrOfBits);
        //Shift the value so the bits you want are the most right ones.
        long shiftedValue = value >> (startBit - nrOfBits);

        //Use this for printing the entire bits
        //long t = temp & mask;
        //System.out.println("Original value is: " + String.format("%32s", Long.toBinaryString(value)).replace(' ', '0') + " mask is: " + String.format("%32s", Long.toBinaryString(mask)).replace(' ', '0') + " value & mask is: " + String.format("%32s", Long.toBinaryString(t)).replace(' ', '0'));

        //Remove all unnecessary bits to 0 by ANDing with the mask.
        return shiftedValue & mask;
    }

    //TODO: Remove these functions and replace with getters and setters for each field.
    //TODO: Give the user more freedom how to use the values in this class.
    public static void printHeaders() {
        System.out.printf("%-20s%-10s%-20s%-20s%-30s%-20s\n", "instruction", "FMT", "Decomposition", "Decomp hex", "Source", "Comment");
    }

    public void printValues() {
        System.out.printf("%-20s%-10s%-20s%-20s%-30s%-20s\n", instruction, type, decomp, decompHex, abbr, comment);
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDecomp() {
        return decomp;
    }

    public void setDecomp(String decomp) {
        this.decomp = decomp;
    }

    public String getDecompHex() {
        return decompHex;
    }

    public void setDecompHex(String decompHex) {
        this.decompHex = decompHex;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
