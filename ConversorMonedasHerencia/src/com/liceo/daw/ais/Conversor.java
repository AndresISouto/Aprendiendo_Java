package com.liceo.daw.ais;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            menu();
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Introduce la cantidad de Dólares a cambiar");
                    Moneda dolar = new Dolar(sc.nextDouble());
                    System.out.println("Equivale a: " + dolar.enEuros() + "euros");
                    break;
                case 2:
                    System.out.println("Introduce la cantidad de Libras a cambiar" + "euros");
                    Moneda libra = new Libra(sc.nextDouble());
                    System.out.println("Equivale a: " + libra.enEuros());
                    break;
                case 3:
                    System.out.println("Introduce la cantidad de Yenes a cambiar" + "euros");
                    Moneda yen = new Yen(sc.nextDouble());
                    System.out.println("Equivale a: " + yen.enEuros());
                    break;
                case 0:
                    System.out.println("Gracias");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Introduce una opción válida");
                    break;
            }

        }while (true);
    }

    private static void menu() {
        System.out.print("""
                CONVERSOR DE MONEDAS
                1. Dólares
                2. Libras
                3. Yens
                0. Salir
                Escoja una opción:\s
                """);
    }
}
