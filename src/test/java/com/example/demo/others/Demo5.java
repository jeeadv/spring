package com.example.demo.others;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo5
{
    @Test
    public void test()
    {
        //print odd elements which occurs odd number of times
        //arr = [1, 2, 2, 4, 2, 4]
        List<Integer> list = Stream.of(1, 2, 2, 4, 2, 4).collect(Collectors.groupingBy(x -> x))
                .values().stream().filter(array -> array.size() % 2 == 1).map(array -> array.get(0)).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test1()
    {
        Map<?, ?> result = Stream.of("kumar:M", "Kumari:F", "Gaurav:M").collect(Collectors.groupingBy(s -> s.split(":")[1]));
        System.out.println(result);
    }
}
