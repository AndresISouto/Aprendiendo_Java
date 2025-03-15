package com.liceo.daw.ais;

public class Dolar extends Moneda{
    @Override
    public double enEuros() {
        return cantidad*0.97;
    }
    public Dolar(double cantidad) {
        this.cantidad=cantidad;
    }
}
