package com.liceo.daw.ais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private double salario;
    private int departamento;
    private String dniJefe;

    public Empleado(String dni, String nombre, String apellido1, String apellido2, Date fechaNacimiento, double salario,
                    int departamento, String dniJefe) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.departamento = departamento;
        this.dniJefe = dniJefe;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        String fechaNacimiento = sdf.format(this.fechaNacimiento);
        if (this.apellido2 == null){
            String apellido2 = "NULL";
        }
        if (this.dniJefe == null){
            String dniJefe = "NULL";
        }
        return "('" + dni + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', '" + fechaNacimiento + "', '" + salario + "', '" + departamento + "', '" + dniJefe + "')";
    }

}
