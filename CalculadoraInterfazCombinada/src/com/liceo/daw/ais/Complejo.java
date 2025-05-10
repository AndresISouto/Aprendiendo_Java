package com.liceo.daw.ais;

public class Complejo implements Numero {

    private double real;
    private double imaginario;

    public Complejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public double getReal() {
        return real;
    }

    public double getImaginario() {
        return imaginario;
    }

    @Override
    public Numero suma(Numero num) {
        double a = this.real;
        double b = this.imaginario;

        if (num instanceof Entero){
            Entero operando = (Entero) num;
            double c = operando.getValor();
            double d = 0;
            return new Complejo(a+c,b+d);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            double c = operando.getNumerador()/ operando.getDenominador();
            double d = 0;
            return new Complejo(a+c,b+d);
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo(a+c,b+d);
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero resta(Numero num) {
        double a = this.real;
        double b = this.imaginario;

        if (num instanceof Entero){
            Entero operando = (Entero) num;
            double c = operando.getValor();
            double d = 0;
            return new Complejo(a - c,b+d);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            double c = operando.getNumerador()/ operando.getDenominador();
            double d = 0;
            return new Complejo(a - c,b);
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo(a - c,b-d);
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero producto(Numero num) {
         double a = this.real;
        double b = this.imaginario;

        if (num instanceof Entero){
            Entero operando = (Entero) num;
            double c = operando.getValor();
            double d = 0;
            return new Complejo(a*c-b*d,a*d+b*c);
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            double c = operando.getNumerador()/ operando.getDenominador();
            double d = 0;
            return new Complejo(a*c-b*d,a*d+b*c);
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo(a*c-b*d,a*d+b*c);
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public Numero division(Numero num) {
        double a = this.real;
        double b = this.imaginario;

        if (num instanceof Entero){
            Entero operando = (Entero) num;
            double c = operando.getValor();
            double d = 0;
            return new Complejo((a*c+b*d)/(c*c+d*d),(b*c-a*d)/(c*c+d*d));
        } else if (num instanceof Racional) {
            Racional operando = (Racional) num;
            double c = operando.getNumerador()/ operando.getDenominador();
            double d = 0;
            return new Complejo((a*c+b*d)/(c*c+d*d),(b*c-a*d)/(c*c+d*d));
        } else if (num instanceof Complejo) {
            Complejo operando = (Complejo) num;
            double c = operando.getReal();
            double d = operando.getImaginario();
            return new Complejo((a*c+b*d)/(c*c+d*d),(b*c-a*d)/(c*c+d*d));
        }else {
            throw new ClassCastException("Esta funcion solo suma objetos de tipo Entero,Racional o Complejo");
        }
    }

    @Override
    public String mostrar() {
        return real + " + " + imaginario+"i";
    }
}
