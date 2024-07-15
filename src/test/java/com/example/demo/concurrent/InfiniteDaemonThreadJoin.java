package com.example.demo.concurrent;

public class InfiniteDaemonThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
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
        thread.join();

        System.out.println("Main thread stopped.");
    }
}
