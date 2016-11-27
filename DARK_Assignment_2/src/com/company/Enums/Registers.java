package com.company.Enums;

/**
 * Created by c13vzs on 2016-11-17.
 */
public class Registers {

    private Registers() {
    }

    /**
     * Gives you the register abbrevation for a given value
     * @param value - The given value
     * @return The register abbrevation for the value
     */
    public static String getAbbrFromValue(long value) {
        String abbr = null;
        if(value == 0) {
            abbr = "$zero";
        } else if (value == 1) {
            abbr = "$at";
        } else if (value == 2 || value == 3) {
            abbr = "$v" + (value-2);
        } else if (value >=4 && value <= 7) {
            abbr = "$a" + (value-4);
        } else if (value >= 8 && value <= 15) {
            abbr = "$t" + (value-8);
        } else if (value == 24 || value == 25) {
            abbr = "$t" + (value-16);
        } else if (value == 26 || value == 27) {
            abbr = "$k" + (value-26);
        } else if (value == 28) {
            abbr = "$gp";
        } else if (value == 29) {
            abbr = "$sp";
        } else if (value == 30) {
            abbr = "$fp";
        } else if (value == 31) {
            abbr = "$ra";
        }
        return abbr;
    }
}
