package com.example;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter expression('/'-exit):");
            String nextLine = reader.nextLine();
            if (nextLine.equals("/")) break;
            Parser parcer = new Parser(nextLine);
            System.out.println(" = " + parcer.parse());
        }
    }
}
