package com.liceo.daw.ais;

import java.util.Scanner;

public class Entrada {
    protected int codigo;
    protected double precio;
    protected Asistente asistente;

    private int contadorID =1;

    public Entrada( double precio, Asistente asistente) {
        this.codigo = contadorID;
        contadorID++;
        this.precio = precio;
        this.asistente = asistente;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public static Entrada crearEntrada(Asistente asistente){
        Scanner sc = new Scanner(System.in);

        System.out.println("Quieres una entrada de pista Y/N");
        String opcion = sc.nextLine();
        if(opcion.equalsIgnoreCase("y")){
            System.out.println("La quieres con acceso al backstage? Y/n");
            String back = sc.nextLine();
            if (back.equalsIgnoreCase("y")){
                return new EntradaPista(1000,asistente,true);
            }
            else{
                return new EntradaPista(500,asistente,false);
            }
        }
        else {
            System.out.println("Tu entrada será de grada por favor elije la fila de la 1 a la 25");
            int fila = sc.nextInt();
            while (fila <1 || fila>25){
                System.out.println("por favor elija una fila válida");
            }
            System.out.println("Por favor elija un asiento del 1 al 1000");
            int asiento = sc.nextInt();
            while (asiento <1 || asiento>1000){
                System.out.println("por favor elija un asiento válido");
            }
            return new EntradaGrada(100,asistente,fila,asiento);
        }

    }
}
