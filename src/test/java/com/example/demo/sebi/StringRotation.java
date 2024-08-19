package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringRotation
{
    @Test
    public void test()
    {
        Assertions.assertEquals("umarshanuk", rotateLeft("kumarshanu", 1));
        Assertions.assertEquals("ukumarshan", rotateRight("kumarshanu", 1));

        Assertions.assertEquals("marshanuku", rotateLeft("kumarshanu", 2));
        Assertions.assertEquals("nukumarsha", rotateRight("kumarshanu", 2));

        Assertions.assertEquals("kumarshanu", rotateLeft("kumarshanu", 10));
        Assertions.assertEquals("kumarshanu", rotateRight("kumarshanu", 10));
    }

    public String rotateLeft(String s, int i)
    {
        i = i % s.length();
        return s.substring(i, s.length()) + s.substring(0, i);
    }

    public String rotateRight(String s, int i)
    {
        i = i % s.length();
        return rotateLeft(s, s.length() - i);
    }
}
