package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private final static String OPERATIONS[] = {"+", "-", "*", "/", "(", ")"};

    public static void main(String[] args) {
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter expression('/'-exit):");
            String nextLine = reader.nextLine();
            if(nextLine.equals("/")) break;
            RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(preparate(nextLine));
            System.out.println(" = " + recursiveDescentParser.parse());
        }
    }

    private static String[] preparate(String input) {

        for (String operator : OPERATIONS) {
            String operatorForReplacement = " " + operator + " ";
            input = input.replace(operator, operatorForReplacement);
        }
        String[] tokens = input.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        list.removeAll(Arrays.asList(""));
        String[] tokens_new = new String[list.size()];
        return list.toArray(tokens_new);
    }
}
