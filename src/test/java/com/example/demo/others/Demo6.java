package com.example.demo.others;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

public class Demo6
{
    public static void main(String[] args)
    {

        /*Symbol       Value

        I             1

        V             5

        X             10

        L             50

        C             100

        D             500

        M             1000

        IV, IX, XC, CM

        LVIII -> 58

        IV-4

        I
      IV

        IX-9

        XXXIX-39

        XLIX

        XXXIX -> xxx 1) xxxi -> xxxix 2) xxxix




        */

    }

    Map<Character, Integer> symbolMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50);

    @Test
    public void test()
    {
        Assertions.assertEquals(1, decimal("I", 0));
        Assertions.assertEquals(3, decimal("III", 0));
        Assertions.assertEquals(4, decimal("IV", 0));
        Assertions.assertEquals(5, decimal("V", 0));
        Assertions.assertEquals(9, decimal("IX", 0));
        Assertions.assertEquals(39, decimal("XXXIX", 0));
        Assertions.assertEquals(40, decimal("XL", 0));

    }

    int decimal(String s, int i)
    {
        //System.out.println("(" + i + ")");
        if (i >= s.length())
        {
            return 0;
        }

        if (isSpecialValidCombination(s, i, i+1))
        {
            //System.out.println("Special: " + calculateDecimal(s, i, i+1));
            return decimal(s, i+2) + calculateDecimal(s, i, i+1);
        }
        else
        {
            //System.out.println("Normal: " + calculateDecimal(s, i));
            return decimal(s, i+1) + calculateDecimal(s, i);
        }
    }

    int calculateDecimal(String s, int i, int j)
    {
        return symbolMap.get(s.charAt(j)) - symbolMap.get(s.charAt(i));
    }
    int calculateDecimal(String s, int i)
    {
        return symbolMap.get(s.charAt(i));
    }

    boolean isSpecialValidCombination(String s, int i, int j)
    {
        if (j >= s.length())
        {
            return false;
        }
        return Set.of("IV", "IX", "XL").contains("" + s.charAt(i) + s.charAt(j));
    }
}
