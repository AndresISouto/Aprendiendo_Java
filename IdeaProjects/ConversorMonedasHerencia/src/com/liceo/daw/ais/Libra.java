package com.liceo.daw.ais;

public class Libra extends Moneda{
    @Override
    public double enEuros() {
        return cantidad*1.03;
    }

    public Libra(double cantidad) {
        this.cantidad=cantidad;
    }
}
