package com.example.demo;

import java.util.Random;
import java.util.Set;

public class Demo10
{
    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 0; i < 17; i++)
        {
            //System.out.print(random.nextInt(100) + " ");
        }

        System.out.println(Set.of(Integer.valueOf(-1), 2).equals(Set.of(2, -1)));
    }
}
