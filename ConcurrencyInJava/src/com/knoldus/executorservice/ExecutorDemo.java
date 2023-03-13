package com.knoldus.executorservice;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

    class Task implements Runnable {
        private int value;
         Task(int value) {
            this.value = value;
        }

        public void run() {
            System.out.println("Value of each instances: " + value);
        }
    }
    public class ExecutorDemo {
        public static void main(String[] args) {

            ExecutorService executor = Executors.newFixedThreadPool(10);
            for (int index = 1; index <= 10; index++) {
                Task task = new Task(index);
                Future<?> future = executor.submit(task);
                try {
                    future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

