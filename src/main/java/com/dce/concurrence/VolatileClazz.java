package com.dce.concurrence;

public class VolatileClazz {

	private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                	System.out.println(Thread.currentThread().getName()+"执行while循环");
                }
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                	System.out.println(Thread.currentThread().getName()+"执行while循环");
                }
            }
        });
        thread.start();
        thread2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
