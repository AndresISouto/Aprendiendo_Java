package com.liceo.das.ais;

import java.time.LocalDate;
import java.util.Scanner;

public class Socio {
    private static int contador_ID =1;

    private final String DNI;
    private final LocalDate nacimiento;
    private final int numero_Socio;

    private String nombre;
    private String apellidos;
    private String email;
    private int numeroDeLibros =0;
    private Libro[] librosPrestados = new Libro[5];

    public Socio(String DNI, LocalDate nacimiento, String email, String apellidos, String nombre) {
        this.DNI = DNI;
        this.nacimiento = nacimiento;
        this.numero_Socio = contador_ID;
        this.email = email;
        this.apellidos = apellidos;
        this.nombre = nombre;

        contador_ID++;
    }
    public int getNumero_Socio(){
        return numero_Socio;
    }

    public static Socio crearSocio(){
        Scanner sc = new Scanner(System.in);
        String DNI;
        LocalDate nacimiento;
        int anho,mes,dia;
        String nombre;
        String apellidos;
        String email;

        System.out.println("Introduce el nombre del socio");
        nombre = sc.next();// sc.nextLine()
        System.out.println("Introduce el apellido del socio");
        apellidos = sc.next();//sc.nextLine()
        System.out.println("Introduce el mail del socio");
        email = sc.next();//sc.nextLine()
        System.out.println("Introduce el dni del socio");
        DNI = sc.next();//sc.nextLine()
        System.out.println("Introduce el año de nacimiento del socio");
        anho = sc.nextInt();//Integer.parseInt(sc.nextLine())
        System.out.println("Introduce el mes de nacimiento del socio");
        mes = sc.nextInt();//Integer.parseInt(sc.nextLine())
        System.out.println("Introduce el día de nacimiento del socio");
        dia = sc.nextInt();//Integer.parseInt(sc.nextLine())

        nacimiento = LocalDate.of(anho,mes,dia);

        return new Socio(DNI,nacimiento,email,apellidos,nombre);
    }
    public void tomarPrestado(Libro libro){
        if (libro == null) {
            System.out.println("No se puede tomar prestado un libro no valido");
        }
        else if(numeroDeLibros >=5){
            System.out.println("Solo puedes tener un máximo de 5 libros, devuelve uno antes de coger otro");

        }
        else if(!libro.isDisponible()){
            System.out.println("Este libro no está disponible");
        }
        else {
            librosPrestados[numeroDeLibros] = libro;
            numeroDeLibros++;
            libro.setDisponible(false);
        }

    }

    public void devolverLibro(){
        Scanner sc = new Scanner(System.in);
        boolean devuelto = false;
        for(int i = 0; i <numeroDeLibros;i++){
                librosPrestados[i].toString();

        }
        System.out.println("Que libro quieres devlver? Introduce el ISBN");
        String opcion = sc.next();

        for (int i = 0; i < numeroDeLibros; i++) {
            if (opcion.equals(librosPrestados[i].getISBN())) {
                librosPrestados[i].setDisponible(true);
                devuelto = true;
                for (int j = i; j <numeroDeLibros ; j++) {
                    librosPrestados[j] = librosPrestados[j+1];
                }
                numeroDeLibros--;
                System.out.println("libro eliminado");
            }
        }
        if (!devuelto){
            System.out.println("No se encontró ninguna coincidencia, por favor, intentalo de nuevo");
        }
    }
    public void mostrarLibrosDeSocio(){
        for (int i = 0; i < numeroDeLibros; i++) {
            System.out.println(librosPrestados[i].toString());
        }
    }
}
