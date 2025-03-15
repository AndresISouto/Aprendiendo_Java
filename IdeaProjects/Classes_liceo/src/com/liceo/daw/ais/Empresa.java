package com.liceo.daw.ais;

public class Empresa {

    private static Empleado[] empleados;

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("12345678A", "javier", "Gomez", "VArela", 26, 1200.54);
        Empleado empleado2 = new Empleado("12345789B","Paco","Perez","Perez",56,2300.98);
        Empleado empleado3 = new Empleado("Smith","1234","john",45,1000);
        Jefe jefe1 = new Jefe("12345","juan","perez","perez",62,50000,2);
        System.out.println(empleado1.getNombre());

        empleados = new Empleado[3];
        empleados[0]= empleado1;
        empleados[1]= empleado2;
        empleados[2]= jefe1;

        for (int i = 0; i < empleados.length; i++) {
            System.out.println(empleados[i].toString());
        }
    }
}