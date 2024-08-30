package com.example.demo.sebi.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest
{
    @Test
    public void test()
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        try
        {
            stack.pop();
            Assertions.fail();
        }
        catch (Exception e)
        {
            Assertions.assertTrue(e instanceof EmptyStackException);
        }
    }

}
