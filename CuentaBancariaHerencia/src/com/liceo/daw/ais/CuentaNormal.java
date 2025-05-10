package com.liceo.daw.ais;

public class CuentaNormal extends CuentaBancaria{
    public CuentaNormal(double saldo) {
        super(saldo);
    }

    @Override
    public void retirarDinero(double cantidad) {
       if (consultarSaldo() >= cantidad){
           super.retirarDinero(cantidad);
       }
       else {
           System.out.println("Operación inválida");
       }
    }
}
