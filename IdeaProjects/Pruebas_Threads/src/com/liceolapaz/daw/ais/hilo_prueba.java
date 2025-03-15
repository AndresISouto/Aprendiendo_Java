package com.liceolapaz.daw.ais;

public class hilo_prueba  {

/* Recordar wait,notify, Atomic, locks, collecciones concurrentes
* */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Thread thread = new Thread(runnable,"hilo 1");
        thread.start();
    }

}
