package com.liceo.daw.ais;

public abstract class Moneda {
    protected double cantidad;

    public double getCantidad() {
        return cantidad;
    }

    public abstract double enEuros();
}
