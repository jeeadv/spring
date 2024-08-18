package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamAPIsExample
{
    @Test
    public void empty()
    {
        Stream<String> emptyStream = Stream.empty();
        emptyStream.map(x -> String.valueOf(x)).filter(x -> x.equals("")).collect(Collectors.toList());
    }

    @Test
    public void of()
    {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        Assertions.assertEquals(List.of("1 1", "3 3"), stream.filter(x -> x % 2 == 1).map(x -> x + " " + x).collect(Collectors.toList()));
    }

    @Test
    public void array()
    {
        Arrays.stream(new int []{1, 2, 3});
        Arrays.stream(new int []{1, 2, 3}, 4, 5);
    }

    @Test
    public void intstream()
    {
        IntStream.of(1, 2, 3);
    }

    @Test
    public void builder()
    {
        Stream<Object> stream = Stream.builder().add(1).add("2").add(3L).add(true).add(new Object()).add(1.414).build();
        //stream.forEach(x -> System.out.println(x));
        Assertions.assertTrue(stream.filter(x -> x.equals(1)).findAny().isPresent());
        //Assertions.assertTrue(stream.filter(x -> x.equals("2")).findAny().isPresent());
    }

    @Test
    public void generate()
    {
        Stream<Integer> stream = Stream.generate(() -> 123).limit(5);
        stream.forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void iterate()
    {
        Stream<BigInteger> stream = Stream.iterate(new BigInteger("2"), x -> x.multiply(x)).limit(9);
        stream.forEach(x -> System.out.print(x + " "));

        System.out.println();
        Stream<Long> stream1 = Stream.iterate(2L, x -> x * x).limit(7);
        stream1.forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void primitive()
    {
        IntStream.of(987654321, 2, 3).forEach(x -> System.out.print(x + " "));
        System.out.println();
        LongStream.of(1234567890123456789L, 5, 6).forEach(x -> System.out.print(x + " "));
        System.out.println();
        DoubleStream.of(1.54, 4.56, 3).forEach(x -> System.out.print(x + " "));;
        System.out.println();
        IntStream.range(1, 8).forEach(x -> System.out.print(x + " "));
        System.out.println();
        LongStream.rangeClosed(1, 3).forEach(x -> System.out.print(x + " "));
        System.out.println();

    }

    @Test
    public void random()
    {
        DoubleStream doubleStream = new Random().doubles(2);
        doubleStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        IntStream stream = "abc".chars();
        stream.forEach(x -> System.out.print((char) x + " "));
    }

    @Test
    public void regex()
    {
        Pattern.compile(",").splitAsStream("a,b,c").forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void file() throws IOException
    {
        Files.lines(Paths.get("D:\\Interviews\\wissen.txt")).forEach(x -> System.out.println(x + " "));
    }

    @Test
    public void multipleTerminalOperationWithoutError()
    {
        Stream<String> stream = Stream.of("a", "b", "c");
        List<String> filtered = stream.filter(e -> e.equals("c")).collect(Collectors.toList());
        filtered.stream().findAny();
        filtered.stream().findFirst();
    }

    @Test
    public void pipeline()
    {
        List<String> list = Arrays.asList("abc11", "abc22", "abc33");
        list.stream().skip(2).map(element -> element.substring(0, 4)).sorted().forEach(x -> System.out.println(x));
    }

    @Test
    public void lazyInvocation()
    {
        AtomicInteger count = new AtomicInteger();
        Stream.of(1, 2, 3, 4).filter(n -> {
            count.getAndIncrement();
            return n % 2 == 0;
        }).findFirst();

        Assertions.assertEquals(count.get(), 2);
    }

    @Test
    public void max()
    {
        Assertions.assertEquals(4, Stream.of(1, 2, 3, 4).count());
        Assertions.assertEquals(4, Stream.of(1, 2, 3, 4).max((x, y) -> x - y).get());
        Assertions.assertEquals(1, Stream.of(1, 2, 3, 4).min((x, y) -> x - y).get());
    }

    @Test
    public void reduce()
    {
        // identity, accumulator, combiner

        Optional<Integer> accumulator = Stream.of(1, 2, 3).reduce((a, b) -> a + b);
        Assertions.assertEquals(6, accumulator.get());

        int identity = Stream.of(1, 2, 3).reduce(20, (a, b) -> a + b);
        Assertions.assertEquals(26, identity);

        int combiner = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (x, y) -> x + y);
        Assertions.assertEquals(16, combiner);
    }

    @Test
    public void reduceString()
    {
        Assertions.assertEquals("a, b, c, d", Stream.of("a", "b", "c", "d").collect(Collectors.joining(", ")));
        Assertions.assertEquals("[a, b, c, d]", Stream.of("a", "b", "c", "d").collect(Collectors.joining(", ", "[", "]")));
    }

    @Test
    public void sum()
    {
        int sum = Stream.of(1, 2, 3, 4, 5).collect(Collectors.summingInt(x -> x * x));
        Assertions.assertEquals(25 + 16 + 9 + 4 + 1, sum);

        double average = Stream.of(1, 2, 3, 4, 5).collect(Collectors.averagingInt(x -> x));
        Assertions.assertEquals(3, average);

        IntSummaryStatistics statistics = Stream.of(1, 2, 3, 4, 5).collect(Collectors.summarizingInt(x -> x));
        System.out.println(statistics);
    }

    @Test
    public void grouping()
    {
        Map<Integer, List<Integer>> collection = Stream.of(1, 2, 3, 4, 1, 2, 6, 8, 10).collect(Collectors.groupingBy(x -> x));
        System.out.println(collection);

        Map<Boolean, List<Integer>> collection1 = Stream.of(1, 2, 3, 4, 1, 2, 6, 8, 10).collect(Collectors.groupingBy(x -> x % 2 == 0));
        System.out.println(collection1);
    }

    @Test public void reduce1()
    {
        Assertions.assertEquals("abcd", Stream.of("a", "ab", "abc", "abcd").reduce((a, b) -> a.length() > b.length() ? a: b).get());
        Assertions.assertEquals("ab", Stream.of("a", "ab").reduce((a, b) -> a.length() > b.length() ? a: b).get());
        Assertions.assertEquals("a", Stream.of("a").reduce((a, b) -> a.length() > b.length() ? a: b).get());
    }
}
