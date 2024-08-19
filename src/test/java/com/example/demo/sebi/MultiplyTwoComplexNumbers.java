package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MultiplyTwoComplexNumbers
{
    @Test
    public void test()
    {
        Assertions.assertEquals(List.of(2, 0), multiply(1, 1, 1, -1));
        Assertions.assertEquals(List.of(-5, 10), multiply(1, 2, 3, 4));
    }

    public List<Integer> multiply(int a, int b, int c, int d)
    {
        return List.of(a*c - b*d, a*d + b*c);
    }
}
