package com.liceo.daw.ais;

public class Racional implements Numero{
    private int numerador;
    private int denominador;

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    @Override
    public Numero suma(Numero num) {
        int  numerador = ((Racional)num).numerador;
        int  denominador = ((Racional)num).denominador;

        return new Racional(this.numerador*denominador+this.denominador*numerador
                ,this.denominador*denominador);
    }

    @Override
    public Numero multiplicacion(Numero num) {
        int  numerador = ((Racional)num).numerador;
        int  denominador = ((Racional)num).denominador;
        return new Racional(this.numerador*numerador,this.denominador*denominador);
    }

    @Override
    public Numero resta(Numero num) {
        int  numerador = ((Racional)num).numerador;
        int  denominador = ((Racional)num).denominador;
        return new Racional(this.numerador*denominador-this.denominador*numerador
                ,this.denominador*denominador);
    }

    @Override
    public Numero division(Numero num) {
        int  numerador = ((Racional)num).numerador;
        int  denominador = ((Racional)num).denominador;
        return new Racional(this.numerador*denominador,this.denominador*numerador);
    }

    @Override
    public String mostrar() {
        return numerador + "/" + denominador ;
    }
}
