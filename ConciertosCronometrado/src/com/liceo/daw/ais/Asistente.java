package com.liceo.daw.ais;

import java.time.LocalDate;
import java.util.Scanner;

public class Asistente {
    private  String nombre;
    private String apellidos;
    private String dni;
    private String mail;
    private LocalDate nacimiento;

    public Asistente(String nombre, String apellidos, String dni, String mail, LocalDate nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.mail = mail;
        this.nacimiento = nacimiento;
    }

    public String getMail() {
        return mail;
    }

    public static Asistente crearAsistente(){
        Scanner sc = new Scanner(System.in);
        String nombre, apellido,dni,mail;
        int anho,mes,dia;
        System.out.println("Introduzca el nombre");
        nombre = sc.nextLine();
        System.out.println("Introduzca el apellido");
        apellido = sc.nextLine();
        System.out.println("Introduzca el dni");
        dni = sc.nextLine();
        System.out.println("Introduzca el mail");
        mail = sc.nextLine();
        System.out.println("Introduzca el año de nacimiento");
        anho = sc.nextInt();
        System.out.println("Introduzca el mes de nacimiento");
        mes = sc.nextInt();
        System.out.println("Introduzca el día de nacimiento");
        dia = sc.nextInt();

        return new Asistente(nombre,apellido,dni,mail,LocalDate.of(anho,mes,dia));

    }

    public boolean validarEdad(){
    LocalDate now = LocalDate.now();
    LocalDate minus18 = now.minusYears(18);

        return nacimiento.isBefore(minus18);


    }
}
