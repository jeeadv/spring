package com.example.demo.sebi.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PriorityQueueTest
{
    @Test
    public void test()
    {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new java.util.PriorityQueue<>();
        queue.add(4);
        queue.add(2);
        queue.add(1);
        queue.add(3);

        while(!queue.isEmpty())
        {
            int top = queue.poll();
            list.add(top);
        }
        Assertions.assertEquals(List.of(1, 2, 3, 4), list);

        list = new ArrayList<>();
        Queue<Integer> queue1 = new java.util.PriorityQueue<>((a, b) -> b.compareTo(a));
        queue1.add(4);
        queue1.add(2);
        queue1.add(1);
        queue1.add(3);

        while(!queue1.isEmpty())
        {
            int top = queue1.poll();
            list.add(top);
        }
        Assertions.assertEquals(List.of(4, 3, 2, 1), list);
    }
}
