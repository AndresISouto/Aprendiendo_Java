package com.liceo.daw.ais;

public class Complejo implements Numero {
    private int real;
    private  int imaginario;

    public Complejo(int real, int imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public int getReal() {
        return real;
    }

    public int getImaginario() {
        return imaginario;
    }

    @Override
    public Numero suma(Numero num) {
        int real = ((Complejo)num).real;
        int imaginario = ((Complejo)num).imaginario;
        return new Complejo(this.real+real,this.imaginario+imaginario);
    }

    @Override
    public Numero multiplicacion(Numero num) {
        int a =real;
        int b = imaginario;
        int c = ((Complejo)num).real;
        int d = ((Complejo)num).imaginario;
        return new Complejo(a*c-b*d,a*d+b*c);
    }

    @Override
    public Numero resta(Numero num) {
        int real = ((Complejo)num).real;
        int imaginario = ((Complejo)num).imaginario;
        return new Complejo(this.real-real,this.imaginario-imaginario);
    }

    @Override
    public Numero division(Numero num) {
        int a =real;
        int b = imaginario;
        int c = ((Complejo)num).real;
        int d = ((Complejo)num).imaginario;
        return new Complejo((a*c+b*d)/(c*c+d*d),(b*c-a*d)/(c*c+d*d));
    }

    @Override
    public String mostrar() {
        if (imaginario>0){
        return real + "+" + imaginario + "i";}
        else if (imaginario == 0){return real + "";}
        else {
            return real + "-" + imaginario*(-1) + "i";}
        }
    }


