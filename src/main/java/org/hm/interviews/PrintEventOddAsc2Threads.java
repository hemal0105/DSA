package org.hm.interviews;

public class PrintEventOddAsc2Threads {
    volatile static int counter = 1;
    int n = 10;

    public synchronized void printOdd() {
        while (counter <= n) {
            if (counter % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void printEven() {
        while (counter <= n) {
            if (counter % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) {
        PrintEventOddAsc2Threads printer = new PrintEventOddAsc2Threads();

        Thread thread1 = new Thread(printer::printEven);
        Thread thread2 = new Thread(printer::printOdd);

        thread1.setName("Even");
        thread2.setName("Odd");

        thread1.start();
        thread2.start();
    }
}
