package com.company;

import com.company.Exceptions.NotValidInstructionException;
import com.company.Instructions.Instruction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            //Read instructions from a file
            br = new BufferedReader(new FileReader("/home/c13/c13vzs/IdeaProjects/DARK_Assignment_1/src/com/company/Test.txt"));
            //Read each line
            Instruction.printHeaders();
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                Instruction inst = InstructionBuilder.getInstructionFromNumeric(sCurrentLine);
                if(inst != null) {
                    instructions.add(inst); //Make an instruction object and save it
                    inst.printValues();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotValidInstructionException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}