package com.liceolapaz.daw.ais;

public class Hilo_sleep {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(threadName + "acabó");
        };

        Thread thread = new Thread(runnable,"hilo 1");
        thread.start();
    }
}