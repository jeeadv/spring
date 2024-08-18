package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        for (int i = 0; i < s.length(); i += 2)
        {
            shift(s, i, shift++, arr);
            shift(s, i + 1, -shift++, arr);
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
