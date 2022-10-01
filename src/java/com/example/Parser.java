package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private final static String[] OPERATIONS = {"+", "-", "*", "/", "(", ")"};
    private static String[] tokens;

    public Parser(String input) {

        for (String operator : OPERATIONS) {
            String operatorForReplacement = " " + operator + " ";
            input = input.replace(operator, operatorForReplacement);
        }
        tokens = input.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        list.removeAll(List.of(""));
        String[] tokens_new = new String[list.size()];
        tokens = list.toArray(tokens_new);
    }

    public Double parse() {
        Calculator calculation = new Calculator(tokens);
        return calculation.expression();

    }
}
