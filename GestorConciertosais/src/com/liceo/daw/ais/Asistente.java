package com.liceo.daw.ais;

import java.time.LocalDate;
import java.util.Scanner;

public class Asistente {

    private String nombre;
    private String dni;
    private String apellidos;
    private String mail;
    private LocalDate fecha_nacimiento;

    public Asistente(String nombre, String dni, String apellidos, String mail, int anho,int mes, int dia) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellidos = apellidos;
        this.mail = mail;
        this.fecha_nacimiento = LocalDate.of(anho,mes,dia);
    }

    public String getMail() {
        return mail;
    }

    public static Asistente createAsistente(){
        Scanner sc = new Scanner(System.in);
        String nombre,dni,apellidos,mail;
        int year,month,day;

        System.out.println("Introduce el nombre del asistente");
        nombre = sc.nextLine();
        System.out.println("Introduce el apellido del asistente");
        apellidos = sc.nextLine();
        System.out.println("Introduce el mail del asistente");
        mail = sc.nextLine();
        System.out.println("Introduce el dni del asistente");
        dni = sc.nextLine();
        System.out.println("Introduce el año de nacimiento del asistente");
        year = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el mes de nacimiento del asistente");
        month = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el día de nacimiento del asistente");
        day = Integer.parseInt(sc.nextLine());

        return new Asistente(nombre,dni,apellidos,mail,year,month,day);
    }
    public boolean validateEdad(){
        LocalDate now = LocalDate.now();
        LocalDate minus18 = now.minusYears(18);

        if (this.fecha_nacimiento.isBefore(minus18)){return true;}
        else {return false;}
    }


}
