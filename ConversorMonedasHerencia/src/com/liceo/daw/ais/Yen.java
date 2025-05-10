package com.liceo.daw.ais;

public class Yen extends Moneda{

    @Override
    public double enEuros() {
        return cantidad*0.0062;
    }
    public Yen(double cantidad) {
        this.cantidad=cantidad;
    }
}
