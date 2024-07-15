package com.example.demo.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        Future<String> future = Executors.newSingleThreadExecutor().submit( () -> System.out.println("other thread ending"), "string");

        System.out.println("Result: " + future.get());
        System.out.println("main thread ending");
    }
}
