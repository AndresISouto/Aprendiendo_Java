package com.liceolapaz.daw.ais;

import java.util.Scanner;

public class Jugador {
//    private static int contadorID=1;

    private int ID;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String posicion;
    private Equipo equipo = null;

    public Jugador( int id,String nombre, String nacionalidad, int edad, String posicion) {
        this.ID = id;
//        contadorID++;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.posicion = posicion;
    }

    public int getID() {
        return ID;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public static Jugador crearJugador(){
        Scanner sc = new Scanner(System.in);
        String nombre, nacionalidad,posicion;
        int edad,id;

        System.out.println("Introduzca el nombre");
        nombre = sc.nextLine();
        System.out.println("Introduzca la nacionalidad");
        nacionalidad = sc.nextLine();
        System.out.println("Introduzca la posicion");
        posicion = sc.nextLine();
        System.out.println("Introduzca la edad");
        edad = sc.nextInt();
        System.out.println("Introduzca el id");
        id = sc.nextInt();

        return new Jugador(id,nombre,nacionalidad,edad,posicion);
    }

    public void ingrasarAlEquipo(Equipo equipo){
       if(equipo.getCantidadJugadores()<15) {
           equipo.setJugadores(this);
           this.equipo = equipo;
       }
       else {
           System.out.println("ya tiene 15 jugadores");
       }

    }

    @Override
    public String toString() {
        if (equipo != null){
        return "Jugador{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + equipo.getNombre() +
                '}';
        }
        else {
            return "Jugador{" +
                    "ID=" + ID +
                    ", nombre='" + nombre + '\'' +
                    ", nacionalidad='" + nacionalidad + '\'' +
                    ", edad=" + edad +
                    ", posicion='" + posicion + '\'' +
                    '}';
        }
    }
}
