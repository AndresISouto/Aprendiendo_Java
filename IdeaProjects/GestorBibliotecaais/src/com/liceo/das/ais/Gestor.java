package com.liceo.das.ais;

import java.util.Scanner;

public class Gestor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion,numero;
        String ISBN;
        Biblioteca biblioteca =new Biblioteca();
        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1://crear socio
                    biblioteca.addSocio(Socio.crearSocio());
                    break;
                case 2:// crear libro
                    biblioteca.addLibro(Libro.crearLibro());
                    break;
                case 3://llevarse un libro
                    System.out.println("Indica que socio quiere llevarse el libro");
                    numero = sc.nextInt();
                    System.out.println("Indica el ISBN de libro que se quiera llevar");
                    ISBN = sc.next();
                    biblioteca.buscarSocio(numero).tomarPrestado(biblioteca.buscarLibro(ISBN));
                    break;
                case 4:
                    System.out.println("Indica que socio quiere devolver el libro");
                    numero = sc.nextInt();
                    biblioteca.buscarSocio(numero).devolverLibro();
                    break;
                case 5:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 6:
                    biblioteca.mostrarLibrosNoDisponibles();
                    break;
                case 7:
                    System.out.println("Indica de que socio quieres ver sus libros");
                    numero = sc.nextInt();
                    biblioteca.buscarSocio(numero).mostrarLibrosDeSocio();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestro programa");
                    System.exit(0);
                    break;
                default :
                    System.out.println("Tecla no válida");
            }
        }while(true);

    }
    public static void menu(){
        System.out.println("""
                GESTOR BIBLIOTECA
                1. Crear socio
                2. Crear libro
                3. Llevarse libro
                4. Devolver libro
                5. Mostrar libros disponibles
                6. Mostrar libros no disponibles
                7. Mostrar libros de un socio
                0. Salir
                Escoja una opción:\s
                """);
    }
}
