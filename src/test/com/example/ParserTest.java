package com.example;

import org.testng.annotations.Test;

public class ParserTest {

    static final String[] inputArray ={
            "1+(-21*3-7)",
            "1/2+(8-7)",
            "(-128+128)/128+-9",
            "(800+88)/(888-88)"
    };
    static final double[] resultArray = {-69.0, 1.5, -9.0, 1.11};
    @Test
    void testParser(){
        for(int i=0; i < inputArray.length; i++) {
            Parser parser = new Parser(inputArray[i]);
            double result = parser.parse();
            assert (result == resultArray[i]);
        }
    }
}
