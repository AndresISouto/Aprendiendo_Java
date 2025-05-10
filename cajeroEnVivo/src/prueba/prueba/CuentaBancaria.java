package prueba;

public abstract class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void retirarDinero(double cantidad );

   public void ingresarDinero(double cantidad){
       saldo = saldo + cantidad;
   }
   public double consultarSaldo(){
       return saldo;
   }
}
