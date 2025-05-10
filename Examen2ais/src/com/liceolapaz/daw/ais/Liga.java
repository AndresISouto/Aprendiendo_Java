package com.liceolapaz.daw.ais;

import java.util.Scanner;

public class Liga {
    private Equipo[] equipos = new Equipo[18];
    private int numeroEquipos = 0;
    private Jugador[] jugadoresSinEquipo = new Jugador[100];
    private int numeroJugadoresSinEquipo=0;
    private Jugador[] jugadores = new Jugador[100];
    private int jugadoresLiga=0;

    public Liga() {
    }

    public boolean nombreUsado(String nombre){
        for (int i = 0; i < numeroEquipos; i++) {
            if (equipos[i].getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    public boolean idUsado(int id){
        for (int i = 0; i < jugadoresLiga; i++) {
            if (jugadores[i].getID() == id){
                return true;
            }
        }
        return false;
    }


    public Equipo buscarEquipoPorNombre(String nombre){
        for (int i = 0; i < numeroEquipos; i++) {
            if (equipos[i].getNombre().equalsIgnoreCase(nombre)){
                return equipos[i];
            }
        }
        System.out.println("no esxiste tal equipo");
        return null;
    }

    public void agregarEquipoLiga(Equipo equipo){
        if (nombreUsado(equipo.getNombre())){
            System.out.println("Ese nombre ya está usado");
        }
        else {
            equipos[numeroEquipos]=equipo;
            numeroEquipos++;
            System.out.println("Se ha añadido con éxito su equipo");
        }
    }
    public void agregarJugadorSinEquipo(Jugador jugador){
        jugadoresSinEquipo[numeroJugadoresSinEquipo]=jugador;
        numeroJugadoresSinEquipo++;
        jugador.setEquipo(null);
    }
    public void agregarJugadorALaLiga(Jugador jugador){
        if (idUsado(jugador.getID())){
            System.out.println("Este id ya está asignado");
        }
        else {

            jugadores[jugadoresLiga]=jugador;
            jugadoresLiga++;
        }
    }

    public void mostrarJugadoresSinEquipo(){
        for (int i = 0; i < numeroJugadoresSinEquipo; i++) {
            System.out.println(jugadoresSinEquipo[i].toString());
        }
    }
    public void JugadorAlMercado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduzca el id del jugador a dejar fuera del equipo");
        int opcion = Integer.parseInt(sc.nextLine());
        Jugador jugador = buscarJugadorPorID(opcion);
        jugador.getEquipo().sacarJudador(jugador);
        agregarJugadorSinEquipo(jugador);
    }
    public  void transferirJugador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduzca el id del jugador a transferir");
        int opcion = Integer.parseInt(sc.nextLine());
        if (idUsado(opcion)){
            Jugador jugador = buscarJugadorPorID(opcion);
            System.out.println("elije a que equipo quieres que vaya");
            String nombre = sc.nextLine();
            if (nombreUsado(nombre)){
                Equipo equipo = buscarEquipoPorNombre(nombre);
                if (jugador.getEquipo()!= null){
                        jugador.getEquipo().sacarJudador(jugador);
                        jugador.ingrasarAlEquipo(equipo);
                }
                else { //sin equipo
                    jugadorFichado(jugador);
                    jugador.ingrasarAlEquipo(equipo);
                }
            }

        }
        else {
            System.out.println("id no válido");
        }

    }
   public Jugador buscarJugadorPorID(int id){
        for (int i = 0; i < jugadoresLiga; i++) {
            if (jugadores[i].getID() == id){
                return jugadores[i];
            }
        }
        System.out.println("No se encontró tal jugador");
        return null;
    }
    public void jugadorFichado(Jugador jugador){

        for (int i = 0; i < numeroJugadoresSinEquipo; i++) {
            if (jugadoresSinEquipo[i].getID() == jugador.getID()){
                jugadoresSinEquipo[i]=null;
                for (int j = i; j < numeroJugadoresSinEquipo; j++) {
                    jugadoresSinEquipo[j]=jugadoresSinEquipo[j+1];
                }
            }
        }
        numeroJugadoresSinEquipo--;    }

}
