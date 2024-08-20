package com.example.demo.others;

import java.util.*;

public class Demo
{
    public static void main(String[] args)
    {
        //String s = "Gaurav Kumar";
        //Character repeated = getSecondRepeatedChar(s);
        //System.out.println(repeated);

        String[] array = new String[] {"abc", "bca", "dog", "god"};
        Optional<Integer> reduced = Arrays.stream(array).map(e -> {
            int count = 0;
            for (Character c: e.toCharArray())
            {
                if (c == 'a') {
                    count++;
                }
            }
            return count;
        }).reduce((a, b) -> a + b);
        System.out.println(reduced.get());
    }

    public static Character getSecondRepeatedChar(String s)
    {
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        int found = 0;
        for (Character c: s.toCharArray())
        {
            if (set.contains(c))
            {
                set2.add(c);
                if (set2.size() == 2)
                {
                    return c;
                }
            }
            set.add(c);
        }
        return null;
    }
}
