package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DayOnTheDate
{
    @Test
    public void test() throws ParseException
    {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        Assertions.assertEquals(1, cal.get(Calendar.DAY_OF_WEEK));

        cal = new GregorianCalendar();
        cal.setTime(new Date(2024, Calendar.AUGUST, 18));
        Assertions.assertEquals(1, cal.get(Calendar.DAY_OF_WEEK));

    }
}
