package com.liceo.das.ais;

public class Biblioteca {
    private String nombre = "Biblioteca por defecto";
    private Libro[] libros = new Libro[5000];
    private Socio[] socios = new Socio[1000];
    private int numeroLibros=0;
    private int numeroSocios=0;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public Biblioteca() {}

    public void addLibro(Libro libro){
        libros[numeroLibros] = libro;
        numeroLibros++;
    }
    public void addSocio(Socio socio){
        socios[numeroSocios] = socio;
        numeroSocios++;
    }
    public void mostrarLibrosDisponibles(){

        for (int i = 0; i < numeroLibros; i++) {
            if (libros[i].isDisponible()){
                System.out.println(libros[i].toString());
            }
        }
    }
    public void mostrarLibrosNoDisponibles(){
        for (int i = 0; i < numeroLibros; i++) {
            if (!libros[i].isDisponible()){
                System.out.println(libros[i].toString());
            }
        }

    }
    public Libro buscarLibro(String ISBN){
        for (int i = 0; i < numeroLibros; i++) {
            if (libros[i].getISBN().equals(ISBN)) {
                return libros[i];
            }
        }
        System.out.println("Este ISBN no coincide con ningun libro");
        return null;
    }
    public Socio buscarSocio(int numero_de_Socio){
        for (int i = 0; i < numeroSocios; i++) {
            if (socios[i].getNumero_Socio() == numero_de_Socio) {
                return socios[i];
            }
        }
        System.out.println("Este numero no coincide con ningun socio");
        return null;
    }
}
