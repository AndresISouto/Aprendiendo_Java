package com.liceo.daw.ais;

public class EntradaGrada extends Entrada{
    private int fila;
    private int asiento;

    public EntradaGrada(double precio, Asistente asistente, int fila, int asiento) {
        super(precio, asistente);
        this.fila = fila;
        this.asiento = asiento;
    }

    public int getFila() {
        return fila;
    }

    public int getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        return "EntradaGrada{" +
                "fila=" + fila +
                ", asiento=" + asiento +
                ", codigo=" + codigo +
                ", precio=" + precio +
                '}';
    }
}
