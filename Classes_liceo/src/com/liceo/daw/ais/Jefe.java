package com.liceo.daw.ais;

public class Jefe extends Empleado{

    private int codigoDepartamento;

    public Jefe(String dni, String nombre, String apellido1, String apellido2, int edad, double salario, int codigoDepartamento) {
        super(dni, nombre, apellido1, apellido2, edad, salario);
        this.codigoDepartamento = codigoDepartamento;
    }

    @Override
    public double calcularSalarioNeto() {
        return super.calcularSalarioNeto();

    }

    @Override
    public String toString() {
        return "Jefe{" +
                "codigoDepartamento=" + codigoDepartamento +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
