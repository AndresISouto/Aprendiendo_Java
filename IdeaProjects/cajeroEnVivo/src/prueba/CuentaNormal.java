package prueba;

public class CuentaNormal extends CuentaBancaria{

    public CuentaNormal(double saldo) {
        super(saldo);
    }

    @Override
    public void retirarDinero(double cantidad) {
        if (consultarSaldo() >= cantidad){
            setSaldo( consultarSaldo() - cantidad) ;
        }
        else {
            System.out.println("Operación no válida");
        }
    }
}
