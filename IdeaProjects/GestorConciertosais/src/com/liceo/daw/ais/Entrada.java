package com.liceo.daw.ais;

import java.util.Scanner;

public class Entrada {

    private static int id_auto_increment;
    protected final int codigo;
    protected double precio;

    protected Asistente asistente;

    public Asistente getAsistente() {
        return asistente;
    }

    public Entrada(double precio, Asistente asistente ) {
        this.codigo = id_getAndIncrement();
        this.precio = precio;
        this.asistente = asistente;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                ", asistente=" + asistente +
                '}';
    }

    public int id_getAndIncrement(){
        int aux = id_auto_increment;
        id_auto_increment++;
        return aux;
    }

    public static Entrada createEntradaFor(Asistente asistente){
        Scanner sc =new Scanner(System.in);

        System.out.println("Quiere una entrada de pista? Y/N");
        if (sc.next().equalsIgnoreCase("y")){
            return EntradaPista.createEntradaPistaFor(asistente);
        }
        else {
            System.out.println("Será entonces de grada");
            return EntradaGrada.createEntradaGradaFor(asistente);
        }
    }
}
