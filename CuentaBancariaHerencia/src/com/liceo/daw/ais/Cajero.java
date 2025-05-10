package com.liceo.daw.ais;

import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = null;
        
        do {
        menu();
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                 cuenta = crearCuenta();
                break;
            case 2://ingresar
                if (cuenta != null){
                    System.out.println("Introduce la cantidad a ingresar");
                    cuenta.ingresarDinero(sc.nextDouble());
                }else {
                    System.out.println("Crea una cuenta antes de introducir dinero");
                }

                break;
            case 3://retirar
                if (cuenta != null){
                    System.out.println("Introduce la cantidad a retirar");
                    cuenta.retirarDinero(sc.nextDouble());
                }else {
                    System.out.println("Crea una cuenta antes de retirar dinero");
                }
                break;
            case 4:
                if (cuenta != null){
                    System.out.println(cuenta.consultarSaldo() + "€");
                }else {
                    System.out.println("Crea una cuenta antes de consultar tu dinero");
                }

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

    private static CuentaBancaria crearCuenta() {
        Scanner sc = new Scanner(System.in);

        subMenu();

        int opcion = sc.nextInt();
        CuentaBancaria cuenta = null;

        switch (opcion){
            case 1:
                System.out.println("Introduce la cantidad inicial");
                cuenta = new CuentaNormal(sc.nextDouble());
                break;
            case 2:
                System.out.println("Introduce la cantidad inicial");
                cuenta = new CuentaPremium(sc.nextDouble());
                break;
            case 0:
                break;
            default:
                System.out.println("Introduce una opción válida");
                break;
        }
        return cuenta;
    }

    private static void subMenu() {
        System.out.print("""
                Tipo de cuenta
                1. Cuenta normal
                2. Cuenta Premium
                0. Cancelar
                Escoja una opción:\s
                """);
    }

    private static void menu() {
        System.out.print("""
                BANCO
                1. Crear cuenta
                2. Ingresar dinero
                3. Retirar dinero
                4. Consultar saldo
                0. Salir
                Escoja una opción:\s
                """);
    }
}
