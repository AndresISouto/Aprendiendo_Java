package com.liceo.daw.ais;

import java.util.Scanner;

public class EntradaGrada extends Entrada {

    private static final double PRECIO_GRADA = 50;

    private int fila;
    private int asiento;

    public EntradaGrada(Asistente asistente, int fila, int asiento) {
        super(PRECIO_GRADA, asistente);
        this.fila = fila;
        this.asiento = asiento;
    }


    @Override
    public String toString() {
        return "EntradaGrada{" +
                "asiento=" + asiento +
                ", codigo=" + codigo +
                ", precio=" + precio +
                ", asistente=" + asistente +
                ", fila=" + fila +
                '}';
    }

    public int getFila() {
        return fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public static EntradaGrada createEntradaGradaFor(Asistente asistente){
        Scanner sc = new Scanner(System.in);
        int fila =0;
        int asiento = 0;
        System.out.println("Elija la fila en la que se quiere sentar");
        fila = sc.nextInt();
        System.out.println("Elija el asiento en el que se quiere sentar");
        asiento = sc.nextInt();

        return new EntradaGrada(asistente,fila,asiento);
    }

}
