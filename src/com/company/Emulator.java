package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Emulator {

    static int AC = 0, AX = 0, F = 0, PC;
    static final int[] MEMORY = new int[256];
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader objReader = new BufferedReader(new FileReader("program.txt"));
        String line;
        ArrayList<String> operations = new ArrayList<>();

        while ((line = objReader.readLine()) != null) {
            operations.add(line);
        }
        objReader.close();
        
        int value;
        String[] instructions;
        boolean running = operations.get(0).equals("START");
        PC = 0;
        while (running) {
            int lastPC = PC;
            instructions = operations.get(PC).split(" ");
            //System.out.println(instructions[0]);
            if (instructions.length == 1) {

                if (instructions[0].equals("HALT")) {
                    running = false;
                    System.out.println("Execution stopped.");

                } else if (instructions[0].equals("DISP")) {
                    System.out.print(AC);

                } else if (instructions[0].equals("DASC")) {
                    char ascii = (char) AC;
                    System.out.print(ascii);

                } else {
                    execute(instructions[0], -1);
                }
            } else {
                value = Integer.parseInt(instructions[1]);
                execute(instructions[0], value);
            }
            if (lastPC == PC) { // it will increase PC if there was no jump execution
                PC += 1;
            }
        }
    }

    public static void execute(String instruction, int value) {
        switch (instruction) {
            case "LOAD":
                AC = value;
                break;
            case "LOADM":
                AC = MEMORY[value];
                break;
            case "LOADI":
                AC = MEMORY[AX];
                break;
            case "STORE":
                MEMORY[value] = AC;
                break;
            case "STOREI":
                MEMORY[AX] = AC;
                break;
            case "CMPM":
                F = Integer.compare(AC, MEMORY[value]);
                break;
            case "CJMP":
                if (F > 0)
                    PC = value;
                break;
            case "JMP":
                PC = value;
                break;
            case "ADD":
                AC += value;
                break;
            case "ADDM":
                AC += MEMORY[value];
                break;
            case "SUB":
                AC -= value;
                break;
            case "SUBM":
                AC -= MEMORY[value];
                break;
            case "MUL":
                AC *= value;
                break;
            case "MULM":
                AC *= MEMORY[value];
                break;
            case "PUSH":
                if (value != -1)
                    stack.push(value);
                else
                    stack.push(AC);
                break;
            case "POP":
                AC = stack.pop();
                break;
            case "RETURN":
                PC = stack.pop();
                break;
            case "SWAP":
                AC = AC + AX - (AX = AC);
                break;
        }
    }

}