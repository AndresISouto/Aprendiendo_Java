package com.liceo.daw.ais;

public class Racional implements Numero{

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(double denominador) {
        this.denominador = denominador;
    }

    private double numerador;
    private double denominador;

    public double getNumerador() {
        return numerador;
    }

    public double getDenominador() {
        return denominador;
    }


    public Racional(double numerador, double denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    @Override
    public Numero suma(Numero num) {

        if (num instanceof Entero){
             Entero operando = (Entero) num;
            return operando.suma(this); //new Racional(this.numerador+operando.getValor()*denominador,denominador);
        } else if (num instanceof Racional) {
            double a = this.numerador;
            double b = this.denominador;
            Racional operando = (Racional) num;
            double c = operando.getNumerador();
            double d = operando.getDenominador();
            return new Racional(a*d+b*c,b*d);
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double a = numerador/denominador;
            double b = 0;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo(a+c,b+d);
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero resta(Numero num) {
        if (num instanceof Entero){
        Entero operando = (Entero) num;
        Racional aux = (Racional) operando.resta(this);
        aux.setNumerador(aux.getNumerador()*-1);
        return aux; //new Racional(this.numerador - operando.getValor()*denominador,denominador);
    } else if (num instanceof Racional) {
        double a = this.numerador;
        double b = this.denominador;
        Racional operando = (Racional) num;
        double c = operando.getNumerador();
        double d = operando.getDenominador();
        return new Racional(a*d - b*c,b*d);
    } else if (num instanceof Complejo) {
        Complejo operando = (Complejo) num;
        double a = numerador/denominador;
        double b = 0;
        double c = operando.getReal();
        double d = operando.getImaginario();
        return new Complejo(a-c,d);
    }else {
        throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
    }

    }

    @Override
    public Numero producto(Numero num) {
        if (num instanceof Entero){
            Entero operando = (Entero) num;
            return operando.producto(this); //new Racional(this.numerador+operando.getValor()*denominador,denominador);
        } else if (num instanceof Racional) {
            double a = this.numerador;
            double b = this.denominador;
            Racional operando = (Racional) num;
            double c = operando.getNumerador();
            double d = operando.getDenominador();
            return new Racional(a*c,b*d);
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double a = numerador/denominador;
            double b = 0;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo(a*c,d);
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero division(Numero num) {
        if (num instanceof Entero){
            Entero operando = (Entero) num;
            return new Racional(numerador/operando.getValor(),denominador); //new Racional(this.numerador - operando.getValor()*denominador,denominador);
        } else if (num instanceof Racional) {
            double a = this.numerador;
            double b = this.denominador;
            Racional operando = (Racional) num;
            double c = operando.getNumerador();
            double d = operando.getDenominador();
            return new Racional(a*d,b*c);
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double a = numerador/denominador;
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
        return numerador + "/" + denominador ;
    }
}