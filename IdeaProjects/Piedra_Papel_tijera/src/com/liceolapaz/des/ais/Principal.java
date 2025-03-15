package com.liceolapaz.des.ais;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    /*mostraremos menu
    sacaremos un valor aleatorio para el ordenador
    decidiremos nosotros
    comprobaremos quien gana y mostraremos mensaje
    * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        String jugadaOrdenador,jugador;


        do {
            menu();
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    jugadaOrdenador=generarJugada();
                    jugador=elegirJugada();

                    if (comprobarValidezJugada(jugador)){
                        comprobarGanador(jugador,jugadaOrdenador);
                    }
                    else {
                        System.out.println("Por favor introduce una jugada válida");
                    }



                    break;
                case 0:
                    System.out.println("Gracias por jugar");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor elija una opción válida");
                    break;
            }

        } while (true);


    }

    private static void comprobarGanador(String jugador, String jugadaOrdenador) {
        jugador = jugador.toLowerCase();
        jugadaOrdenador = jugadaOrdenador.toLowerCase();

        switch (jugador){
            case "piedra":
                System.out.println("El jugador escogió: "+ jugador+" y el ordenador: "+ jugadaOrdenador);
                if(jugadaOrdenador.equals("tijera") || jugadaOrdenador.equals("lagarto"))
                {
                    System.out.println("El jugador gana");
                }
                if(jugadaOrdenador.equals("papel") || jugadaOrdenador.equals("spock"))
                {
                    System.out.println("El jugador pierde");
                }
                if (jugadaOrdenador.equals("piedra"))
                {
                    System.out.println("Empate");
                }
                break;
            case "papel":
                System.out.println("El jugador escogió: "+ jugador+" y el ordenador: "+ jugadaOrdenador);

                if(jugadaOrdenador.equals("piedra") || jugadaOrdenador.equals("spock"))
                {
                    System.out.println("El jugador gana");
                }
                if(jugadaOrdenador.equals("tijera") || jugadaOrdenador.equals("lagarto"))
                {
                    System.out.println("El jugador pierde");
                }
                if (jugadaOrdenador.equals("papel"))
                {
                    System.out.println("Empate");
                }

                break;

            case "tijera":
                System.out.println("El jugador escogió: "+ jugador+" y el ordenador: "+ jugadaOrdenador);

                if(jugadaOrdenador.equals("lagarto") || jugadaOrdenador.equals("papel"))
                {
                    System.out.println("El jugador gana");
                }
                if(jugadaOrdenador.equals("piedra") || jugadaOrdenador.equals("spock"))
                {
                    System.out.println("El jugador pierde");
                }
                if (jugadaOrdenador.equals("tijera"))
                {
                    System.out.println("Empate");
                }

                break;

            case "lagarto":
                System.out.println("El jugador escogió: "+ jugador+" y el ordenador: "+ jugadaOrdenador);

                if(jugadaOrdenador.equals("spock") || jugadaOrdenador.equals("papel"))
                {
                    System.out.println("El jugador gana");
                }
                if(jugadaOrdenador.equals("piera") || jugadaOrdenador.equals("tijera"))
                {
                    System.out.println("El jugador pierde");
                }
                if (jugadaOrdenador.equals("lagarto"))
                {
                    System.out.println("Empate");
                }

                break;

            case "spock":
                System.out.println("El jugador escogió: "+ jugador+" y el ordenador: "+ jugadaOrdenador);

                if(jugadaOrdenador.equals("tijera") || jugadaOrdenador.equals("piedra"))
                {
                    System.out.println("El jugador gana");
                }
                if(jugadaOrdenador.equals("papel") || jugadaOrdenador.equals("lagarto   "))
                {
                    System.out.println("El jugador pierde");
                }
                if (jugadaOrdenador.equals("spock"))
                {
                    System.out.println("Empate");
                }

                break;

            default:
                break;

        }

    }

    private static boolean comprobarValidezJugada(String jugador) {
        if (jugador.equalsIgnoreCase("piedra") ||
                jugador.equalsIgnoreCase("papel") ||
                jugador.equalsIgnoreCase("tijera") ||
                jugador.equalsIgnoreCase("lagarto") ||
                jugador.equalsIgnoreCase("spock") ){ return true;}
        else {return false;}
    }



    private static String elegirJugada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su jugada: Piedra,Papel,tijera,Lagarto,Spock");
        return sc.next();
        
    }

    private static String generarJugada() {
        Random random = new Random();
    int opcion = random.nextInt(1,5);
        return switch (opcion) {
            case 1 -> "Piedra";
            case 2 -> "Papel";
            case 3 -> "Tijera";
            case 4 -> "Lagarto";
            case 5 -> "Spock";
            default -> "0";
        };
    }


    private static void menu() {
        System.out.println("""
                PIEDRA PAPEL TIJERA LAGARTO SPOCK
                1. Jugar
                0. Salir
                ESCOJA UNA OPCIÓN:""");
    }
}
