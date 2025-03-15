package com.liceolapaz.des.ais;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    /*
    --guardar carta, puntuacion y cartas de banca y jugador
    --puntuaciones se suman aleatoriamente entre 1 y 11
    --munú de modos de juego
    --sacar cartas a la banca hasta tener por lo menos 16
    --facil es pública normal no
    --sacr cartas y mostrar puntuación total
    --si se pasa de 21 pierde y si acaba en 21 gana
    --menú para seguir jugando(robar carta)
    -- cuando se pare calcular el ganador

    */

    public static void main(String[] args) {

        int opcion;
        int[] banca_puntos_cartas;
        Scanner sc = new Scanner(System.in);

        do {


            menuPrincipal();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1://facil
                    banca_puntos_cartas = roboBanca();
                    System.out.println("La banca cuenta con una puntuación de: " + banca_puntos_cartas[0]);
                    juego(banca_puntos_cartas);
                    break;
                case 2://normal
                    banca_puntos_cartas = roboBanca();
                    juego(banca_puntos_cartas);
                    break;
                case 0:
                    System.out.println("Gracias por jugar");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor introduce un valor válido");
                    break;
            }

        }while (true);

    }

    private static void juego(int[] bancaPuntosCartas) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        int carta,opcion;
        int puntos = rd.nextInt(1, 11);
        int cartas = 1;
        boolean seguirJugando=true;
        String ganador;

        System.out.println("Tu puntuación actual es de: " + puntos);

        do {
            menuSecundario();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1://volver a robar
                    carta=rd.nextInt(1,11);
                    puntos += carta;
                    cartas++;
                    System.out.println("Acabas de robar un: "+carta+" Tu puntuación actual es de: "+puntos);
                    if (puntos == 21){
                        System.out.println("¡Felicidades por ganar!");
                        seguirJugando=false;
                    }
                    if (puntos > 21){
                        System.out.println("¡Ohhhhh! Has perdido");
                        seguirJugando= false;
                    }

                    break;
                case 2://plantarse
                   ganador = comprobarGanador(puntos,cartas,bancaPuntosCartas);
                    System.out.println(ganador);
                    seguirJugando=false;
                    break;
                default:
                    System.out.println("Introduce una opción valida\n");
                    break;
            }


        } while (seguirJugando);


    }

    private static String comprobarGanador(int puntos, int cartas, int[] bancaPuntosCartas) {
        if (bancaPuntosCartas[0] > 21) {
            return "El jugador ganó esta partida";
        }
        if (bancaPuntosCartas[0] == 21) {
            return "El jugador perdió esta partida";
        }

        if (puntos > bancaPuntosCartas[0]){
            return "El jugador ganó esta partida";
        }
        if (puntos < bancaPuntosCartas[0]){
            return "El jugador perdió esta partida";
        }
        if (puntos == bancaPuntosCartas[0]){
            if (cartas > bancaPuntosCartas[1]){
                return "El jugador perdió esta partida";
            }
            if (cartas <= bancaPuntosCartas[1]){
                return "El jugador ganó esta partida";
            }

        }

        return "0";
    }

    private static void menuSecundario() {
        System.out.println("""
                ¿Seguir jugando?
                1.Sí
                2.No
                Escoja una opción:
                """);
    }


    private static int[] roboBanca() {
        int puntos = 0;
        int robo = 0;
        Random rd = new Random();

        while (puntos <= 15) {
            puntos += rd.nextInt(1, 11);
            robo++;
        }
        return new int[]{puntos, robo};
    }


    private static void menuPrincipal() {
        System.out.println("""
                BLACKJACK
                1. Modo fácil
                2. Modo dificil
                0. Salir
                Escoja una opción:""");
    }
}
