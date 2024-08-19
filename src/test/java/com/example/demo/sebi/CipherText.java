package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class CipherText
{
    @Test
    public void test()
    {
        Assertions.assertEquals(null,  printCipher(null));
        Assertions.assertEquals("",  printCipher(""));
        Assertions.assertEquals("bzf",  printCipher("abc"));
        Assertions.assertEquals("bzfzjznzrzvzzzdzhzlzpztzxz",  printCipher("abcdefghijklmnopqrstuvwxyz"));
        Assertions.assertEquals("abbyc",  printCipher("zdycx"));
    }
    public static String printCipher(String s)
    {
        if (s == null)
        {
            return null;
        }


        int shift = 1;
        char[] arr = new char[s.length()];
        for (int j = 0; j < s.length(); j += 2)
        {
            shift(s, j, shift++, arr);
            shift(s, j + 1, -shift++, arr);
        }
        return new String(arr);
    }

    public static void shift(String s, int i, int shift, char[] arr)
    {
        if (i >= s.length())
        {
            return;
        }
        int delta = (s.charAt(i) - 'a' + shift) % 26;
        while(delta < 0)
        {
            delta += 26;
        }
        arr[i] = (char) ('a' + delta);
    }
}
