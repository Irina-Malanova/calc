package com.example;

public class RecursiveDescentParser {
    private final String[] tokens;
    private int pos = 0;
    public RecursiveDescentParser(String[] tokens) {
        this.tokens = tokens;
    }

    public Double parse() {
        Double result = expression();
        if (pos != tokens.length) {
            throw new IllegalStateException("Error in expression at " + tokens[pos]);
        }
        return result;
    }

    // E -> T±T±T±T± ... ±T
    private Double expression() {
        Double first = term();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    // T -> F*/F*/F*/*/ ... */F
    private Double term() {
        Double first = factor();

        while (pos < tokens.length) {
            String operator = tokens[pos];

            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    // F -> N | (E)
    private Double factor() {
        String next = tokens[pos];
        Double result;
        if (next.equals("(")) {
            pos++;
            result = expression();
            String closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalStateException("Unexpected end of expression");
            }
            if (pos < tokens.length && closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }
        pos++;
        return Double.parseDouble(next);
    }
}
