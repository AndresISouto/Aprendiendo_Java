package com.liceo.daw.ais;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
        menu();
        opcion = sc.nextInt();
        switch (opcion){
            case 1:// suma
                menu_Secundario();
                opcion = sc.nextInt();
                valores_Sumas(opcion);
                break;
            case 2://resta
                menu_Secundario();
                opcion = sc.nextInt();
                valores_Resta(opcion);
                break;
            case 3://multiplicacion
                menu_Secundario();
                opcion = sc.nextInt();
                valores_Multiplicacion(opcion);
                break;
            case 4://division
                menu_Secundario();
                opcion = sc.nextInt();
                valores_Division(opcion);
                break;
            case 0:
                System.out.println("Gracias");
                System.exit(0);
                
            default:
                System.out.println("Operación no valida");
                break;
        }
        }while (true);
    }

    private static void valores_Division(int opcion) {
        Scanner sc = new Scanner(System.in);
        switch (opcion){
            case 1://suma enteros
                System.out.println("Introduce un número entero");
                Numero entero1 = new Entero(sc.nextInt());
                System.out.println("Introduce otro número entero");
                Numero entero2 = new Entero(sc.nextInt());

                System.out.println(entero1.division(entero2).mostrar());
                break;
            case 2://suma racionales
                System.out.println("introduce el numerador del primer numero");
                int numerador = sc.nextInt();
                System.out.println("introduce el denominador del primer numero");
                int denominador = sc.nextInt();
                Numero racional1 = new Racional(numerador,denominador);
                System.out.println("introduce el numerador del segundo numero");
                numerador = sc.nextInt();
                System.out.println("introduce el denominador del segundo numero");
                denominador = sc.nextInt();
                Numero racional2 = new Racional(numerador,denominador);
                System.out.println(racional1.division(racional2).mostrar());
                break;
            case 3:
                System.out.println("introduce la parte real del primer numero");
                int real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del primer numero");
                int imaginario = sc.nextInt();
                Numero complejo1 = new Complejo(real,imaginario);
                System.out.println("introduce la parte real del segundo numero");
                real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del segundo numero");
                imaginario = sc.nextInt();
                Numero complejo2 = new Complejo(real,imaginario);
                System.out.println(complejo1.division(complejo2).mostrar());
                break;
            case 0:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private static void valores_Multiplicacion(int opcion) {
        Scanner sc = new Scanner(System.in);
        switch (opcion){
            case 1://suma enteros
                System.out.println("Introduce un número entero");
                Numero entero1 = new Entero(sc.nextInt());
                System.out.println("Introduce otro número entero");
                Numero entero2 = new Entero(sc.nextInt());

                System.out.println(entero1.multiplicacion(entero2).mostrar());
                break;
            case 2://suma racionales
                System.out.println("introduce el numerador del primer numero");
                int numerador = sc.nextInt();
                System.out.println("introduce el denominador del primer numero");
                int denominador = sc.nextInt();
                Numero racional1 = new Racional(numerador,denominador);
                System.out.println("introduce el numerador del segundo numero");
                numerador = sc.nextInt();
                System.out.println("introduce el denominador del segundo numero");
                denominador = sc.nextInt();
                Numero racional2 = new Racional(numerador,denominador);
                System.out.println(racional1.multiplicacion(racional2).mostrar());
                break;
            case 3:
                System.out.println("introduce la parte real del primer numero");
                int real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del primer numero");
                int imaginario = sc.nextInt();
                Numero complejo1 = new Complejo(real,imaginario);
                System.out.println("introduce la parte real del segundo numero");
                real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del segundo numero");
                imaginario = sc.nextInt();
                Numero complejo2 = new Complejo(real,imaginario);
                System.out.println(complejo1.multiplicacion(complejo2).mostrar());
                break;
            case 0:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private static void valores_Resta(int opcion) {
        Scanner sc = new Scanner(System.in);
        switch (opcion){
            case 1://suma enteros
                System.out.println("Introduce un número entero");
                Numero entero1 = new Entero(sc.nextInt());
                System.out.println("Introduce otro número entero");
                Numero entero2 = new Entero(sc.nextInt());

                System.out.println(entero1.resta(entero2).mostrar());
                break;
            case 2://suma racionales
                System.out.println("introduce el numerador del primer numero");
                int numerador = sc.nextInt();
                System.out.println("introduce el denominador del primer numero");
                int denominador = sc.nextInt();
                Numero racional1 = new Racional(numerador,denominador);
                System.out.println("introduce el numerador del segundo numero");
                numerador = sc.nextInt();
                System.out.println("introduce el denominador del segundo numero");
                denominador = sc.nextInt();
                Numero racional2 = new Racional(numerador,denominador);
                System.out.println(racional1.resta(racional2).mostrar());
                break;
            case 3:
                System.out.println("introduce la parte real del primer numero");
                int real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del primer numero");
                int imaginario = sc.nextInt();
                Numero complejo1 = new Complejo(real,imaginario);
                System.out.println("introduce la parte real del segundo numero");
                real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del segundo numero");
                imaginario = sc.nextInt();
                Numero complejo2 = new Complejo(real,imaginario);
                System.out.println(complejo1.resta(complejo2).mostrar());
                break;
            case 0:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private static void valores_Sumas(int opcion) {
        Scanner sc = new Scanner(System.in);
        switch (opcion){
            case 1://suma enteros
                System.out.println("Introduce un número entero");
                Numero entero1 = new Entero(sc.nextInt());
                System.out.println("Introduce otro número entero");
                Numero entero2 = new Entero(sc.nextInt());

                System.out.println(entero1.suma(entero2).mostrar());
                break;
            case 2://suma racionales
                System.out.println("introduce el numerador del primer numero");
                int numerador = sc.nextInt();
                System.out.println("introduce el denominador del primer numero");
                int denominador = sc.nextInt();
                Numero racional1 = new Racional(numerador,denominador);
                System.out.println("introduce el numerador del segundo numero");
                numerador = sc.nextInt();
                System.out.println("introduce el denominador del segundo numero");
                denominador = sc.nextInt();
                Numero racional2 = new Racional(numerador,denominador);
                System.out.println(racional1.suma(racional2).mostrar());
                break;
            case 3:
                System.out.println("introduce la parte real del primer numero");
                int real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del primer numero");
                int imaginario = sc.nextInt();
                Numero complejo1 = new Complejo(real,imaginario);
                System.out.println("introduce la parte real del segundo numero");
                real = sc.nextInt();
                System.out.println("introduce la parte imaginaria del segundo numero");
                imaginario = sc.nextInt();
                Numero complejo2 = new Complejo(real,imaginario);
                System.out.println(complejo1.suma(complejo2).mostrar());
                break;
            case 0:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }

    }
    private static void menu_Secundario() {
        System.out.println("""
                Tipo de números
                1. Números enteros
                2. Números racionales
                3. Números complejos
                0. Cancelar
                Escoja una opción:
                """);
    }

    private static void menu() {
        System.out.println("""
                CALCULADORA
                1. Suma
                2. Resta
                3. Producto
                4. División
                0. Salir
                Escoja una opción:
                """);
    }
}
