package com.liceo.daw.ais;

public class Entero implements Numero{

    private double valor;

    public Entero(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public Numero suma(Numero num) {

        if (num instanceof Entero){
            Entero operando = (Entero) num;
            return new Entero(this.valor + operando.valor);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            return new Racional(this.valor * operando.getDenominador()+operando.getNumerador(), operando.getDenominador());
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            return new Complejo(this.valor+operando.getReal(), operando.getImaginario());
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero resta(Numero num) {
        if (num instanceof Entero){
            Entero operando = (Entero) num;
            return new Entero(this.valor - operando.valor);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            return new Racional(this.valor* operando.getDenominador() - operando.getNumerador(), operando.getDenominador());
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            return new Complejo(this.valor - operando.getReal(), operando.getImaginario());
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero producto(Numero num) {
        if (num instanceof Entero){
            Entero operando = (Entero) num;
            return new Entero(this.valor * operando.valor);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            return new Racional(this.valor *operando.getNumerador(), operando.getDenominador());
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            return new Complejo(this.valor * operando.getReal(), operando.getImaginario());
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }

    }

    @Override
    public Numero division(Numero num) {
        if (num instanceof Entero){
            Entero operando = (Entero) num;
            return new Entero(this.valor / operando.valor);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            return new Racional(this.valor * operando.getDenominador(), operando.getNumerador());
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double a = this.valor;
            double b = 0;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo((a*c+b*d)/(c*c+d*d),(b*c-a*d)/(c*c+d*d));
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public String mostrar() {
        return valor + "";
    }
}
