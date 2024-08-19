package com.example.demo.sebi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateWordFromSentence
{
    @Test
    public void test()
    {
        Assertions.assertEquals("ram is my best so that a boy for good",
                filterDuplicates("ram is my best ram so that is a best boy for my good"));
        Assertions.assertEquals(null, filterDuplicates(null));
        Assertions.assertEquals("", filterDuplicates(""));
        Assertions.assertEquals("This is it", filterDuplicates("This is it"));
        Assertions.assertEquals("what do you mean", filterDuplicates("what do you mean"));
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(filterDuplicates(s));
    }

    public static String filterDuplicates(String s)
    {
        if (s == null)
        {
            return null;
        }
        List<String> list = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(x -> x));
        String result = list.stream().filter(x -> {
            if (map.containsKey(x))
            {
                map.remove(x);
                return true;
            }
            return false;
        }).collect(Collectors.joining(" "));
        return new String(result);
    }
}
