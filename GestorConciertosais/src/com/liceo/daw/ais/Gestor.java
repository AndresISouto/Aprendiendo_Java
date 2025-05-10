package com.liceo.daw.ais;

import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion ;
        Recinto recinto = new Recinto(26000,25,1000,100,25000);
        do {
        menu();
        opcion = sc.nextInt();

        switch (opcion){
            case 1://Reservar entrada
                Asistente asistente = Asistente.createAsistente();
                if (recinto.validarAsistente(asistente)){
                    Entrada entrada =Entrada.createEntradaFor(asistente);
                    recinto.registrarEntrada(entrada);

                    System.out.println(recinto.getEntradasVendidas());
                }
                else{
                    System.out.println("Asistente no valido");
                }
                break;
            case 2://mostrar entrada
                System.out.println("Que entrada quieres?");
                System.out.println(recinto.getEntradas()[(sc.nextInt()-1)].toString());

                break;
            case 3://listar entradas vendidas
                System.out.println(recinto.getEntradasVendidas());
                recinto.listarEntradas();
                break;
            case 4://mostrar entradas disponibles
                System.out.println(recinto.getEntradas().length - recinto.getEntradasVendidas());
                break;
            case 0:
                System.out.println("Grácias por usar este programa");
                System.exit(0);
                break;
             default:
                 System.out.println("Opción no válida");
                break;
        }
        }while(true);
    }
    public static void menu(){
        System.out.println("""
                GESTOR CONCIERTOS
                1. Reservar entrada
                2. Mostrar entrada
                3. Listar entradas vendidas
                4. Mostrar número de entradas disponibles
                0. Salir
                Escoja una opción:\s
                """);
    }
}
