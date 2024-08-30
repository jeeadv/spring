package com.example.demo.sebi.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTest
{
    @Test
    public void test()
    {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort((a, b) -> a.compareTo(b));
        Assertions.assertEquals(List.of(1, 2, 3), list);

        list.sort((a, b) -> b.compareTo(a));
        Assertions.assertEquals(List.of(3, 2, 1), list);
    }
}
