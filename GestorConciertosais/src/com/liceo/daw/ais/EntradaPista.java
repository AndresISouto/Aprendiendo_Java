package com.liceo.daw.ais;

import java.util.Scanner;

public class EntradaPista extends Entrada{

    private static final double PRECIO_PISTA_BACK = 200;
    private static final double PRECIO_PISTA_NOBACK = 100;

    private boolean backstage;

    public EntradaPista(double precio, Asistente asistente, boolean backstage) {
        super(precio, asistente);
        this.backstage = backstage;
    }

    @Override
    public String toString() {
        return "EntradaPista{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                ", asistente=" + asistente +
                "backstage=" + backstage +
                '}';
    }

    public boolean getBackstage(){
        return backstage;
    }
    public static EntradaPista createEntradaPistaFor(Asistente asistente){
        Scanner sc = new Scanner(System.in);
        double precio;
        boolean backstage;

        System.out.println("Con o sin acceso al back? Y/N");
        if(sc.next().equalsIgnoreCase("y")) {
            backstage = true;
            precio = PRECIO_PISTA_BACK;
        }
        else {
            backstage = false;
            precio = PRECIO_PISTA_NOBACK;
        }
        return new EntradaPista(precio, asistente,backstage);
    }
}
