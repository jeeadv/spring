package com.example.demo.sebi.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphDfsAndBfs
{
    @Test
    public void test()
    {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.computeIfAbsent(1, (k) -> new ArrayList<>()).add(3);
        graph.computeIfAbsent(1, (k) -> new ArrayList<>()).add(4);
        graph.computeIfAbsent(4, (k) -> new ArrayList<>()).add(2);
        graph.computeIfAbsent(4, (k) -> new ArrayList<>()).add(6);
        graph.computeIfAbsent(2, (k) -> new ArrayList<>()).add(5);
        List<Integer> list = new ArrayList<>();
        dfs(graph, 1, new HashSet<>(), list);
        Assertions.assertEquals(List.of(1, 3, 4, 2, 5, 6), list);

        Assertions.assertEquals(List.of(1, 3, 4, 2, 6, 5), bfs(graph, 1));

        graph.computeIfAbsent(2, (k) -> new ArrayList<>()).remove(Integer.valueOf(5));
        list = new ArrayList<>();
        dfs(graph, 1, new HashSet<>(), list);
        Assertions.assertEquals(List.of(1, 3, 4, 2, 6), list);

        Assertions.assertEquals(List.of(1, 3, 4, 2, 6), bfs(graph, 1));
    }

    void dfs(Map<Integer, List<Integer>> graph, int i, Set<Integer> visited, List<Integer> list)
    {
        //System.out.println(i);
        if (visited.contains(i))
        {
            return;
        }
        visited.add(i);
        list.add(i);

        if (graph.get(i) != null)
        {
            for (int child : graph.get(i))
            {
                dfs(graph, child, visited, list);
            }
        }
    }

    List<Integer> bfs(Map<Integer, List<Integer>> graph, int i)
    {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty())
        {
            int top = queue.poll();
            list.add(top);
            if (graph.get(top) != null)
            {
                for (int child: graph.get(top))
                {
                    queue.add(child);
                }
            }
        }
        return list;
    }
}
