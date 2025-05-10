package com.liceolapaz.daw.ais;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Equipo {
    private String nombre;
    private String ciudad;
    private String estadio;
    private int capacidadEstadio;
    private Jugador[] jugadores = new Jugador[15];
    private int cantidadJugadores =0;

    public Equipo(String nombre, String ciudad, String estadio, int capacidadEstadio) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.capacidadEstadio = capacidadEstadio;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setJugadores(Jugador jugadore) {
        this.jugadores[cantidadJugadores] = jugadore;
        cantidadJugadores++;
    }

    public static Equipo crearEquipo(){
        Scanner sc = new Scanner(System.in);
        String nombre, ciudad,estadio;
        int capacidadEstadio;

        System.out.println("Introduzca el nombre");
        nombre = sc.nextLine();
        System.out.println("Introduzca la ciudad");
        ciudad = sc.nextLine();
        System.out.println("Introduzca el estadio");
        estadio = sc.nextLine();
        System.out.println("Introduzca el aforo del estadio");
        capacidadEstadio = sc.nextInt();

        return new Equipo(nombre,ciudad,estadio,capacidadEstadio);

    }

    public Jugador buscarJugadorPorID(int id){
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == id){
                return jugadores[i];
            }
        }
        System.out.println("No se encontró tal jugador");
        return null;
    }

    @Override
    public String toString() {


        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estadio='" + estadio + '\'' +
                ", capacidadEstadio=" + capacidadEstadio +
                ", cantidadJugadores=" + cantidadJugadores +
                '}';
    }

    public void sacarJudador(Jugador jugador){
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == jugador.getID()){
                jugadores[i]=null;
                for (int j = i; j < cantidadJugadores; j++) {
                    jugadores[j]=jugadores[j+1];
                }
            }
        }
        cantidadJugadores--;
    }
}
