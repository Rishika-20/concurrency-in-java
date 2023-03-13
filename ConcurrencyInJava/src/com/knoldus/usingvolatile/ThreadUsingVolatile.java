package com.knoldus.usingvolatile;
public class ThreadUsingVolatile extends Thread {
     private static volatile int counter = 0;
     public void increment(){
          ++counter;
     }
    public int  printing(){
        return counter;
    }
      public static void main(String[] args) {
         ThreadUsingVolatile threadUsingVolatile = new ThreadUsingVolatile();

            Thread mainThread = new Thread(() -> {
                while (counter < 10) {
                        threadUsingVolatile.increment();
                        System.out.println("Main thread's values incremented ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread printingThread = new Thread(() -> {
                while (counter < 10) {
                    System.out.println("Printing thread value : "+threadUsingVolatile.printing());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            mainThread.start();
            printingThread.start();
        }
}
