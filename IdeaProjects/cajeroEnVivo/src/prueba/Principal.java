package prueba;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
        mostrarMenu();
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                crearCuenta();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;
            default:
                System.out.println("Opxión no válida");


        }
        }while(true);
    }

    private static void crearCuenta() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        mostrarSubmenu();
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                break;
            case 2:
                break;
                case 0:
                 break;
            default:
                break;
        }
    }

    private static void mostrarSubmenu() {
        System.out.println("""
                Tipo de cuenta
                1. Cuenta normal
                2. Cuenta Premium
                0. Cancelar
                Escoja una opción:
                """);
    }

    private static void mostrarMenu() {
        System.out.println("""
                BANCO
                1. Crear cuenta
                2. Ingresar dinero
                3. Retirar dinero
                4. Consultar saldo
                0. Salir
                Escoja una opción\s
                """);
    }

}
