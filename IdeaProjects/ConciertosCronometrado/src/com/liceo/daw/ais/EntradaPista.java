package com.liceo.daw.ais;

public class EntradaPista extends Entrada{
    private boolean back;

    public EntradaPista(double precio, Asistente asistente, boolean back) {
        super(precio, asistente);
        this.back = back;
    }

    public boolean isBack() {
        return back;
    }

    @Override
    public String toString() {
        return "EntradaPista{" +
                "back=" + back +
                ", codigo=" + codigo +
                ", precio=" + precio +
                '}';
    }
}
