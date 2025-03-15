package com.liceo.daw.ais;

import java.util.Scanner;

public class  Calculadora{

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        Numero primerOperando=null;
        Numero segundoOperando=null;
        int operacion=-1;

    do {

        while (primerOperando==null) {

            showMenuPrimeraOpcion();
            int primeraOpcion = sc.nextInt();
            primerOperando =generateNumber(primeraOpcion);
        }
        while (segundoOperando==null) {
            showMenuSegundaOpcion();
            int segundaOpcion = sc.nextInt();
            segundoOperando = generateNumber(segundaOpcion);
        }
        while(operacion !=1 && operacion !=2 && operacion !=3 && operacion != 4){
            showMenuOperaciones();
            operacion = sc. nextInt();
            if (operacion ==1 || operacion ==2 || operacion ==3 || operacion==4){
                Numero resultado = operar(primerOperando,segundoOperando,operacion);
                if (resultado != null){
                    System.out.println(resultado.mostrar());
                }
            }
        }
        primerOperando = null;
        segundoOperando = null;
        operacion=-1;

    }while (true);
    }


     //         (\(\
     //         ( -.-)
     //         o_(")(")


    private static Numero operar(Numero primerOperando, Numero segundoOperando, int operacion) {
        return switch (operacion) {
            case 1 -> primerOperando.suma(segundoOperando);
            case 2 -> primerOperando.resta(segundoOperando);
            case 3 -> primerOperando.producto(segundoOperando);
            case 4 -> primerOperando.division(segundoOperando);
            default ->  null;
        };

    }

    private static void showMenuOperaciones() {
        System.out.print("""
                OPERACIONES
                1- SUMA
                2- RESTA
                3- PRODUCTO
                4- DIVISIÓN
                ELIJE:\s
                """);
    }

    private static Numero generateNumber(int primeraOpcion)  {
        Scanner sc = new Scanner(System.in);

        switch (primeraOpcion){
            case 1://enteros
                System.out.println("introduce el número");
                double num = sc.nextDouble();
                return new Entero(num);
            case 2://racional
                System.out.println("introduce el númerador");
                double numerador = sc.nextDouble();
                System.out.println("introduce el denominador");
                double denominador = sc.nextDouble();
                return new Racional(numerador,denominador);
            case 3://complejo
                System.out.println("introduce la parte real");
                double real = sc.nextDouble();
                System.out.println("introduce la parte imaginaria");
                double imaginaria = sc.nextDouble();
                return new Complejo(real,imaginaria);
            default:
                System.out.println("opción no válida");
                return null;
        }


    }

    private static void showMenuSegundaOpcion() {
        System.out.print("""
                SEGUNDO NUMERO
                1- ENTERO
                2- RACIONAL
                3- COMPLEJO
                ELIJE:\s
                """);
    }

    private static void showMenuPrimeraOpcion() {
        System.out.print("""
                PRIMER NUMERO:
                1- ENTERO
                2- RACIONAL
                3- COMPLEJO
                ELIJE:\s
                """);

    }
}