package com.example.demo.concurrent;

import java.util.concurrent.*;

public class ExecutorsExample
{
    public static void main(String[] args) throws InterruptedException
    {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.addTask(() -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("OMG");
            }
        });

        //Thread.sleep(6000);

        taskRunner.addTask(() -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("OMG2");
            }
        });
    }
}

class TaskRunner
{
    private ScheduledExecutorService scheduledExecutorService =  Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture scheduledFuture;
    private Runnable task = () -> {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("INIT");
        }
    };

    public TaskRunner()
    {
        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(task, 1,5, TimeUnit.SECONDS);
    }

    public void addTask(Runnable runnable)
    {
        scheduledExecutorService.submit(runnable);
    }
}
