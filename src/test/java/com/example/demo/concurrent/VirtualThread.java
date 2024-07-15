package com.example.demo.concurrent;

public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            Thread.currentThread().setName(String.valueOf(System.currentTimeMillis()));
            System.out.println(Thread.currentThread().getName() + " running!");
        };

        Thread thread1 = Thread.ofVirtual().start(runnable);
        thread1.join();
        Thread thread2 = Thread.ofVirtual().unstarted(runnable);
        thread2.start();
        thread2.join();

        System.out.println(Thread.currentThread().getName() + " running!");

        for (int i = 0; i < 10000; i++)
        {
            Thread.ofVirtual().start(runnable);
        }
    }
}
