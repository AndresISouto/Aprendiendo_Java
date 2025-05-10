package prueba;

public class CuentaPremium extends CuentaBancaria{
    public CuentaPremium(double saldo) {
        super(saldo);
    }

    @Override
    public void retirarDinero(double cantidad) {
        setSaldo(consultarSaldo() - cantidad);
    }
}
