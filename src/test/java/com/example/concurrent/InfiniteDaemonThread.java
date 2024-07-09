package com.example.concurrent;

public class InfiniteDaemonThread {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            while (true) {
                System.out.println("Thread running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(5000);
        System.out.println("Main thread stopped.");
    }
}
