package com.liceo.daw.ais;

public class Pentagono implements FiguraGeometrica{
    double lado;
    double apotema;

    public Pentagono(double lado, double apotema) {
        this.lado = lado;
        this.apotema = apotema;
    }

    @Override
    public double calcularArea() {
        return calcularPerimetro()*apotema/2;
    }

    @Override
    public double calcularPerimetro() {
        return lado*5;
    }
}
