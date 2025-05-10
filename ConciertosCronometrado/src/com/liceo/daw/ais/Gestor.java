package com.liceo.daw.ais;

import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Recinto recinto = new Recinto();
        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1://reservar
                    Asistente asistente = Asistente.crearAsistente();
                    Entrada entrada = Entrada.crearEntrada(asistente);
                    recinto.addEntrada(entrada);
                    break;
                case 2://mostrar entrada
                    System.out.println("introduzca el mail del asistente");
                    String mail = sc.next();
                    System.out.println(recinto.buscarEntrada(mail).toString());
                    break;
                case 3://
                    recinto.mostrarEntradas();
                    break;
                case 4:
                    System.out.println(26000 - recinto.getEntradasVendidas());
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestro programa");
                    break;
                default:
                    System.out.println("por favor introdizca una opción válida");
            }
        }while(true);
    }

    private static void menu(){
        System.out.println("""
        GESTOR CONCIERTOS
        1. Reservar entrada
        2. Mostrar entrada
        3. Listar entradas vendidas
        4. Mostrar número de entradas disponibles
        0. Salir
           Escoja una opción:\s""");
    }
}
