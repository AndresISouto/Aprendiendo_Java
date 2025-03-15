package com.liceo.daw.ais;

public class Empleado {
    protected String dni;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected int edad;
    protected double salario;

    public Empleado(String dni, String nombre, String apellido1, String apellido2, int edad, double salario) {
        this(apellido1, dni, nombre, edad, salario);
        this.apellido2 = apellido2;
    }

    public Empleado(String apellido1, String dni, String nombre, int edad, double salario) {
        this.apellido1 = apellido1;
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public double calcularSalarioNeto(){
        return salario;
    }

    public Empleado(){}


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario){
        this.salario=salario;
    }

    @Override
    public String toString() {
        if (apellido2.equals(null)) {
            return "Empleado{" +
                    "dni='" + dni + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", apellido1='" + apellido1 + '\'' +
                    ", edad=" + edad +
                    ", salario=" + salario +
                    '}';
        }
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
