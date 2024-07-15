package com.example.demo.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        Future<String> future = Executors.newSingleThreadExecutor().submit( () -> {
            System.out.println("other thread ending");
            throw new RuntimeException("Callable can throw Runtime Exception.");

        }, "string");

        System.out.println("Result: " + future.get());
        System.out.println("main thread ending");
    }
}
