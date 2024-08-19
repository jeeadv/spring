package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareStrings
{
    @Test
    public void test()
    {
        Assertions.assertEquals("a=b", check(null, null));
        Assertions.assertEquals("a=b", check("", ""));
        Assertions.assertEquals("a!=b", check(null, ""));
        Assertions.assertEquals("a!=b", check("", null));
        Assertions.assertEquals("a=b", check("DoctorDangerIsMyNameDude", "DoctorDangerIsMyNameDude"));
        Assertions.assertEquals("a<b", check("DangerIs", "Doctor DangerIs My Name Dude"));
        Assertions.assertEquals("a>b", check("Doctor DangerIs My Name Dude", "Name Dude"));
        Assertions.assertEquals("a!=b", check("Ramesh", "ramesh is my name"));
    }

    public String check(String a, String b)
    {
        if (a == null && b == null)
        {
            return "a=b";
        }
        if (a == null || b == null)
        {
            return "a!=b";
        }
        if (a.equals(b))
        {
            return "a=b";
        }
        if (a.contains(b))
        {
            return "a>b";
        }
        if (b.contains(a))
        {
            return "a<b";
        }
        return "a!=b";
    }
}
