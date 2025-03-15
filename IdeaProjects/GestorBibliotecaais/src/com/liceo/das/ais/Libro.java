package com.liceo.das.ais;

import java.util.Scanner;

public class Libro {
    private final String ISBN;
    private String titulo;
    private String genero;
    private int paginas;
    private boolean disponible = true;


    public Libro(String ISBN, String titulo, String genero, int paginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", paginas=" + paginas +
                ", disponible=" + disponible +
                '}';
    }
    public static Libro crearLibro(){
         Scanner sc = new Scanner(System.in);
         final String ISBN;
         String titulo;
         String genero;
         int paginas;

        System.out.println("Introduce el título del libro ");
        titulo = sc.next();
        System.out.println("Introduce el género del libro ");
        genero = sc.next();
        System.out.println("Introduce el número de páginas del libro ");
        paginas = sc.nextInt();
        System.out.println("Introduce el ISBN del libro ");
        ISBN = sc.next();

        return new Libro(ISBN,titulo,genero,paginas);


    }


}
