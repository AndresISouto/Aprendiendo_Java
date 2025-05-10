package com.liceolapaz.des.ais;


import java.util.Random;
import java.util.Scanner;

public class Principal {

    static Random rd = new Random();

    public static void main(String[] args) {

        /*Crearemos primero el menu
        leemos opcion y aplicamos en un bucle

        altura aleatoria

        posición aleatoria entre 5

        habilidades aleatorias y puntos extra reiniciados a no ser que sean 40

        si tenemos puntos extra nos pregunta a que habilidad asignarlos y luego cuantos, comprobaremos si esa asignación es valida y luego la aplicaremos

         */

        Scanner sc = new Scanner(System.in);
        int opcion,altura=0,tiro_2_puntos=0,tiro_3_puntos=0,pase=0,defensa=0,velocidad=0,
                puntos_extra=40,asignacion,media;
        String posicion = "";


        do {
        menu();
        opcion = sc.nextInt();
        switch (opcion){
            case 1://altura
                altura = rd.nextInt(160,235);
                break;
            case 2://posicion
                posicion = generarPosicion();
                break;
            case 3://habilidades
                tiro_3_puntos = rd.nextInt(1,99);
                tiro_2_puntos = rd.nextInt(1,99);
                pase = rd.nextInt(1,99);
                defensa = rd.nextInt(1,99);
                velocidad = rd.nextInt(1,99);

                if (puntos_extra != 40){
                    puntos_extra =40;
                }
                break;
            case 4://puntos extra
                if (puntos_extra == 0){
                    System.out.println("No tienes puntos extra");
                }
                else {
                    System.out.println("Introduce la habilidad a la que le quieras sumar puntos");
                    menuHabilidades();
                    opcion = sc.nextInt();
                    System.out.println("Introduce el número de puntos extra que quieras asignar");
                    asignacion = sc.nextInt();
                    switch (opcion){
                        case 1:
                            if (asignacion <= puntos_extra && (tiro_2_puntos + asignacion) <=99){
                                tiro_2_puntos += asignacion;
                                puntos_extra -= asignacion;
                            }
                            else {
                                System.out.println("Operación inválida");
                            }
                            break;
                        case 2:
                            if (asignacion <= puntos_extra && (tiro_3_puntos + asignacion) <=99){
                                tiro_2_puntos += asignacion;
                                puntos_extra -= asignacion;
                            }
                            else {
                                System.out.println("Operación inválida");
                            }
                            break;
                        case 3:
                            if (asignacion <= puntos_extra && (pase + asignacion) <=99){
                                tiro_2_puntos += asignacion;
                                puntos_extra -= asignacion;
                            }
                            else {
                                System.out.println("Operación inválida");
                            }
                            break;
                        case 4:
                            if (asignacion <= puntos_extra && (defensa + asignacion) <=99){
                                tiro_2_puntos += asignacion;
                                puntos_extra -= asignacion;
                            }
                            else {
                                System.out.println("Operación inválida");
                            }
                            break;
                        case 5:
                            if (asignacion <= puntos_extra && (velocidad + asignacion) <=99){
                                tiro_2_puntos += asignacion;
                                puntos_extra -= asignacion;
                            }
                            else {
                                System.out.println("Operación inválida");
                            }
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;

                    }

                }
                break;
            case 5://mostrar resultados
                media = (tiro_3_puntos+tiro_2_puntos+pase+defensa+velocidad)/5;
                System.out.println(
                        "Altura:" + altura + "\n" +
                        "Posición:" + posicion +  "\n" +
                        "Tiro 2 Puntos:" + tiro_2_puntos +  "\n" +
                        "Tiro 3 Puntos:" + tiro_3_puntos +  "\n" +
                        "Pase:" + pase +  "\n" +
                        "Defensa:" + defensa +  "\n" +
                        "Velocidad:" + velocidad +  "\n" +
                        "Media Habilidades:" + media
                        );

                break;
            case 0:
                System.out.println("Gracias por usar este programa");
                System.exit(0);
                break;
            default:
                System.out.println("Por favor introduce una opción válida");
                break;

        }

        }while (true);

    }

    private static void menuHabilidades() {
        System.out.println("""
                ASIGNACIÓN DE PUNTOS
                1. Tiro 2 puntos
                2. Tiro 3 puntos
                3. Pase
                4. Defensa
                5. velocidad
                Escoja una opción:""");

    }

    private static String generarPosicion() {
        int aux = rd.nextInt(1,5);
        switch (aux){
            case 1:
                return "Base";
            case 2:
                return "Escolta";
            case 3:
                return "Alero";
            case 4:
                return "Ala-Pivot";
            case 5:
                return "Pivot";
            default:
                return "0";

        }
    }

    private static void menu() {
        System.out.println("""
                CREACIÓN JUGADOR
                1. Altura
                2. Posición
                3. Habilidades
                4. Puntos extras
                5. Mostrar jugador
                0. Salir
                Escoja una opción:""");
    }
}
