package com.example.demo.other;

public class CustomFunctionalInterfaceExample
{
    public static void main(String[] args)
    {
        MyFunctionalInterface<String> method = x -> System.out.println(x);
        method.consume("Ramesh");
    }
}

