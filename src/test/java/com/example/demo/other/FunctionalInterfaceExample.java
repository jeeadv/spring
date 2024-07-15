package com.example.demo.other;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample
{
    public static void main(String[] args)
    {
        Consumer<String> consumer = n -> System.out.println(n);
        consumer.accept("Ramesh");

        Predicate<Integer> predicate = n -> n % 2 == 0;
        System.out.println(predicate.test(2));

        Supplier<String> supplier = () -> "Random";
        System.out.println(supplier.get());

        Function<String, Integer> function = n -> Integer.valueOf(n);
        System.out.println(function.apply("1"));
    }
}
