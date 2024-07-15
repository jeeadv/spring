package com.example.demo.concurrent;

public class ThreadCreation {

    public static void main(String[] args) {
        System.out.print(Thread.currentThread().getName());
        System.out.println(" main thread running");

        Thread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName());
                System.out.println(" anonymous thread running");
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
                System.out.print(Thread.currentThread().getName());
                System.out.println(" lambda thread running");
        });
        thread3.start();

        Thread thread4 = new Thread(new MyRunnable(), "MyRunnable");
        thread4.start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName());
        System.out.println(" My thread running");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName());
        System.out.println("My Runnable running");
    }
}

