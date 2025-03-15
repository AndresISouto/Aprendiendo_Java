package com.liceolapaz.daw.ais;

public class Hilo_Parar implements Runnable{

    private boolean stoped = false;



    public synchronized void stop() {
        this.stoped = true;
    }

    private void sleep(int millis){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        System.out.println("corriendo...");
        while (!stoped){
            sleep(1000);
            System.out.println("...");
        }
        System.out.println("parado");
    }

    public static void main(String[] args) throws InterruptedException {
        Hilo_Parar hilo_Parar = new Hilo_Parar();
        Thread hilo = new Thread(hilo_Parar,"hilo 1");
        hilo.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("parando...");
        hilo_Parar.stop();
        hilo.join(); // espera a que acabe el hilo 1
        System.out.println("parado");

    }
}
