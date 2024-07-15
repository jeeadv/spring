package com.example.demo.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTest
{
    @Test
    public void stringLiteralTest()
    {
        Assertions.assertTrue(new String("string") == new String("string"));
    }

}
