package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryToHex
{
    @Test
    public void test()
    {
        Assertions.assertEquals("7aa", binaryToHex("011110101010"));
        Assertions.assertEquals("a", binaryToHex("1010"));
        Assertions.assertEquals("b", binaryToHex("1011"));
        Assertions.assertEquals("c", binaryToHex("1100"));
        Assertions.assertEquals("d", binaryToHex("1101"));
        Assertions.assertEquals("e", binaryToHex("1110"));
        Assertions.assertEquals("f", binaryToHex("1111"));
    }

    public String binaryToHex(String binary)
    {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toString(decimal, 16);
    }
}
