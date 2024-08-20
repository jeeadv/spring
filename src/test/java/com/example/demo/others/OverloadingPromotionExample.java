package com.example.demo.others;

public class OverloadingPromotionExample
{
    public static void main(String[] args)
    {
        add(10, 20);
    }

    //public static void add(int a, int b){ System.out.println("int"); }

    //public static void add(Integer a, Integer b){ System.out.println("Integer"); }

    //public static void add(float a, float b){ System.out.println("float"); }

    //public static void add(long a, long b){ System.out.println("long"); }

    public static void add(Double a, Double b){ System.out.println("Double"); }

    //public static void add(double a, double b){ System.out.println("double"); }

    public static void add(Object a, Object b){ System.out.println("Object"); }
}