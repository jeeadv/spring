package com.example.demo.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running Hello");
            return "Hello";
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running World");
            return "World";
        }).thenApply((s) -> s + " Kumar");

        System.out.println("Main Thread running");
        System.out.println(Stream.of(completableFuture2, completableFuture1).map(x -> x.join()).collect(Collectors.joining(" ")));
        System.out.println("Main Thread ending");
    }
}
