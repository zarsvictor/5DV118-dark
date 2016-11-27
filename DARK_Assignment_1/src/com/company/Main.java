package com.company;

import com.company.Exceptions.NotValidInstructionException;
import com.company.Instructions.Instruction;
import com.company.Builders.InstructionBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            //Read instructions from a file
            br = new BufferedReader(new FileReader(Paths.get("src\\com\\company\\Test.txt").toAbsolutePath().toString()));
            //Read each line
            Instruction.printHeaders();
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                Instruction inst = InstructionBuilder.getInstruction(sCurrentLine);
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
        /*Instruction.printHeaders();
        for (Instruction i : instructions) {
            i.printValues();
        }*/
    }
}
