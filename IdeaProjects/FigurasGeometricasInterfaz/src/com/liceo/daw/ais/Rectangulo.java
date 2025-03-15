package com.liceo.daw.ais;

public class Rectangulo implements FiguraGeometrica{
    double base;
    double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base*altura;
    }

    @Override
    public double calcularPerimetro() {
        return base*2+altura*2;
    }
}
