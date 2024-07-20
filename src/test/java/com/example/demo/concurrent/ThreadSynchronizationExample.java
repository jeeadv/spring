package com.example.demo.concurrent;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ThreadSynchronizationExample
{
    private static List<Integer> counter = new ArrayList<>();

    static
    {
        counter.add(0);
    }

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Even(counter), "even");
        Thread t2 = new Thread(new Odd(counter), "odd");
        t1.start();
        t2.start();
    }
}

class Even implements Runnable
{
    private List<Integer> counter;

    public Even(List<Integer> counter)
    {
        super();
        this.counter = counter;
    }

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (counter)
            {
                if (counter.get(counter.size() - 1) % 2 == 0)
                {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                counter.add(counter.size());
                System.out.print(Thread.currentThread().getName() + ":"+ counter.get(counter.size() - 1) + " ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                counter.notifyAll();
            }
        }
    }
}

class Odd implements Runnable
{
    private List<Integer> counter;

    public Odd(List<Integer> counter)
    {
        super();
        this.counter = counter;
    }

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (counter)
            {
                if (counter.get(counter.size() - 1) % 2 == 1)
                {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                counter.add(counter.size());
                System.out.print(Thread.currentThread().getName() + ":"+ counter.get(counter.size() - 1) + " ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                counter.notifyAll();
            }
        }
    }
}