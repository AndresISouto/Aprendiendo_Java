package com.liceo.daw.ais;

public abstract class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void retirarDinero(double cantidad){
        saldo -= cantidad;
        }

    public void ingresarDinero(double cantidad){
        saldo += cantidad;
    }

    public double consultarSaldo(){
        return saldo;
    }
}
