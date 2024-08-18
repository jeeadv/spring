public class Demo4
{
    static Object resourceA = new Object();
    static Object resourceB = new Object();

    public static void main(String[] args)
    {
        MythreadA threadA = new MythreadA();
        MythreadB threadB = new MythreadB();

        threadA.start();
        threadB.start();
    }

    public static class MythreadA extends Thread
    {
        @Override
        public void run()
        {
            synchronized (resourceA)
            {
                System.out.println("Thread A has acquired lock on Resource A");
                System.out.println("Thread A is waiting for lock on Resource B");
                synchronized (resourceB)
                {
                    System.out.println("Thread A has acquired lock on Resource B");
                }
            }
        }
    }

    public static class MythreadB extends Thread
    {
        @Override
        public void run()
        {
            synchronized (resourceB)
            {
                System.out.println("Thread B has acquired lock on Resource B");
                System.out.println("Thread B is waiting for lock on Resource A");
                synchronized (resourceA)
                {
                    System.out.println("Thread B has acquired lock on Resource A");
                }
            }
        }
    }
}