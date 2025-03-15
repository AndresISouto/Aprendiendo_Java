package com.liceo.daw.ais;

public class Entero implements Numero{
    private int valor;

    public Entero(int valor) {
        this.valor = valor;
    }

    @Override
    public Numero suma(Numero num) {
        Numero resultado = null;

        if (num instanceof Entero){
            Entero op = (Entero)num;
            int nuevo_valor= this.valor + op.valor;
            resultado = new Entero(nuevo_valor);
        }
        else {
            System.out.println("Solo puedes sumar dos enteros");
        }
        return resultado;
    }

    @Override
    public Numero multiplicacion(Numero num) {
        return new Entero(valor * ((Entero)num).valor);
    }

    @Override
    public Numero resta(Numero num) {
        return new Entero(valor - ((Entero)num).valor);
    }

    @Override
    public Numero division(Numero num) {
       try{
           return new Entero(valor / ((Entero)num).valor);

       } catch (Exception e) {
           System.out.println(e.getMessage());
           throw new IllegalArgumentException();
       }
    }

    @Override
    public String mostrar() {
        return Integer.toString(valor);
    }
}
