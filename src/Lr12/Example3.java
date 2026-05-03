package Lr12;

public class Example3 {

    public static final Object lock = new Object();

    public static int number = 1;

    public static void main(String[] args) {
        Thread evenThread = new Thread( () -> {
           synchronized (lock) {
               while (number < 11) {
                   if (number % 2 == 0) {
                       System.out.println(Thread.currentThread().getName() + ": " + number);
                       number++;
                   } else {
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   } lock.notifyAll();
               }
           }
        });

        Thread oddThread = new Thread( () -> {
            synchronized (lock) {
                while (number < 11) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } lock.notifyAll();
                }
            }
        });

        evenThread.setName("Even Thread");
        oddThread.setName("Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}
