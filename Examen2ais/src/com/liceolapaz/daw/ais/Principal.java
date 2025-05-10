package com.liceolapaz.daw.ais;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Liga liga = new Liga();
        do {
        menu();
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion){
            case 1://crear equipo
                Equipo equipo = Equipo.crearEquipo();
                liga.agregarEquipoLiga(equipo);
                break;
            case 2:// añadir jugador
                Jugador jugador = Jugador.crearJugador();
                liga.agregarJugadorALaLiga(jugador);
                System.out.println("A que equipo quieres que vaya?");
                String nombre = sc.nextLine();
                if (liga.nombreUsado(nombre)){
                    jugador.ingrasarAlEquipo(liga.buscarEquipoPorNombre(nombre));
                    System.out.println("El jugador ha sido añadido correctamente al equipo");
                }
                else {
                    System.out.println("No existe un equipo con ese nombre, el jugador se quedará sin quipo");
                    liga.agregarJugadorSinEquipo(jugador);
                }
                break;
            case 3://transferir jugador
                menuTransferencia();
                int opcionTansferencia = Integer.parseInt(sc.nextLine());
                switch (opcionTansferencia){
                    case 1:
                        liga.transferirJugador();
                        break;
                    case 2:
                        liga.JugadorAlMercado();
                        break;
                    default:
                        System.out.println("No se ha realizado ninguna opcion");
                        break;

                }
                break;
            case 4://listar jugadores sin equipo
                liga.mostrarJugadoresSinEquipo();
                break;
            case 5://mostrar equipo
                System.out.println("introduce el nombre del equipo a mostrar");
                String nombreEquipo = sc.nextLine();
                if (liga.nombreUsado(nombreEquipo)){
                    Equipo equipoAMostrar = liga.buscarEquipoPorNombre(nombreEquipo);

                    System.out.println(liga.buscarEquipoPorNombre(nombreEquipo).toString());
                    for (int i = 0; i < equipoAMostrar.getCantidadJugadores(); i++) {
                        System.out.println(equipoAMostrar.getJugadores()[i].toString());
                    }
                }
                else {
                    System.out.println("ese nombre no se corresponde con ningun equipo");
                }
                break;
            case 0:
                System.out.println("Gracias por usar este programa");
                System.exit(0);
                break;
            default:
                System.out.println("Por favor introduzca una opción válida");
                break;
        }
        }while (true);
    }

    private static void menuTransferencia() {
        System.out.println("""
                QUIERES:
                1. Transferir un jugador de un equipo a otro o fichar a un jugador del mercado
                2. Rescindir el contrato de un jugador
                """);
    }

    private static void menu() {
        System.out.println("""
                LIGA BALONCESTO
                1. Añadir equipo
                2. Añadir jugador
                3. Transferir jugador
                4. Listar jugadores sin equipo
                5. Mostrar equipo
                0. Salir
                Escoja una opción:\s
                """);
    }
}
