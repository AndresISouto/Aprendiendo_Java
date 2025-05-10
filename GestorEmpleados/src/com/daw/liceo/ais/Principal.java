package com.daw.liceo.ais;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    private static HashMap<String,Empleado> empleados = new HashMap<>();
    public static void main(String[] args) {

        do {
       escribirMenu();
       int opcion;
       try{
           Scanner sc = new Scanner(System.in);
           opcion = sc.nextInt();
       } catch (Exception e) {
           System.out.println("opcion no valida");
           continue;
       }
       switch (opcion){
           case 1://importar empleados
             importarEmpleados();
               break;
           case 2://agragar empleado
               agregarEmpleado();
               break;
           case 3://modificar empleado, no me dio tiempo a ver a jesus pero es con empleados.replace
               break;
           case 4://eliminar es con .removej
               break;
           case 5://escribir los ficheros
               break;
           case 0:
               break;
           default:
               break;
       }

        }while(true);

    }

    private static void agregarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("escribe el dni del empleado");
        String dni = sc.nextLine();
        if (!comprobarDni(dni)){
            System.out.println("formato incorrecto");
            return;
        }
        if (empleados.containsKey(dni)){
            System.out.println("el dni esta usado");
            return;
        }
        System.out.println("escribe el nombre");
        String nombre = sc.nextLine();
        if (nombre.isEmpty()){
            System.out.println("nombre invalido");
            return;
        }
        System.out.println("escribe el primer apellido");
        String apellido1 = sc.nextLine();
        if (apellido1.isEmpty()){
            System.out.println("apellido invalido");
            return;
        }
        System.out.println("escribe el segundo apellido");
        String apellido2 = sc.nextLine();
        System.out.println("escribe la fecha de nacimiento formato yyyy/m/d");
        String fechaTexto = sc.nextLine();
        Date fecha = validarFecha(fechaTexto);
        if (fecha == null){
            System.out.println("fecha invalido");
            return;
        }
        System.out.println("escribe el salario");
        double salario;
        try {
        salario = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("formato incorrecto");
            return;
        }
        System.out.println("introduce el departamento");
        int departamento;
        try{
            departamento = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("numero no valido");
            return;
        }
        System.out.println("dni del jefe");
        String dniJefe = sc.nextLine();
        if (!dniJefe.isEmpty()){
            if (!comprobarDni(dniJefe)){
                return;
            }
        }
        Empleado empleado = new Empleado(dni,nombre,apellido1,apellido2,fecha,salario,departamento,dniJefe);

        empleados.put(dni,empleado);
    }

    private static void importarEmpleados() {
        //System.out.println("escribe la ruta del fichero");
       String ruta = "empleados.txt";
       File fichero = new File(ruta);
        if (!fichero.isFile()) {
            System.out.println("La ruta no es un fichero");
            return;
        }
        try {
            Scanner sc = new Scanner(fichero);
            String linea;
           if (sc.hasNextLine()){
               sc.nextLine();
           }
           while (sc.hasNextLine()){
               linea = sc.nextLine();
               String[] campos = linea.split(", ");
              if (campos.length != 8){
                  System.out.println("formato del fichero invalido");
                  return;
              }
              String dni = campos[0].substring(2, campos[0].length()-1);
             if (!comprobarDni(dni)){
                 System.out.println("dni no valido");
                 return;
             }
             String nombre = campos[1].substring(1,campos[1].length()-1);
               String apellido1 = campos[2].substring(1,campos[2].length()-1);
               String apellido2;
               if (campos[3].equals("NULL")){
                   apellido2 = null;
               }
               else {
                   apellido2 = campos[3].substring(1,campos[3].length()-1);
               }

               String fechaTexto= campos[4].substring(1, campos[4].length()-1);
               Date fechaNacimiento = validarFecha(fechaTexto);
               if (fechaNacimiento == null){
                   System.out.println("formato de fecha incorrecto ej xxx/x/x");
                   return;
               }
               String salarioTexto = campos[5].substring(1, campos[5].length()-1);
               double salario;
               try {
                   salario = Double.parseDouble(salarioTexto);
               } catch (NumberFormatException e) {
                   System.out.println("salario en formato incorrecto");
                   return;
               }
               String departamentoTexto = campos[6];
               int departamento;
               try{
                    departamento = Integer.parseInt(departamentoTexto);
               } catch (NumberFormatException e) {
                   System.out.println("formato invalido de departamento");
                   return;
               }
               String dniJefeTexto;

               if (campos[7].equals("NULL)")) {
                  dniJefeTexto = null;
               }
               else {
                  dniJefeTexto = campos[7].substring(1, campos[7].length()-2);
                  if (!comprobarDni(dniJefeTexto)){
                      System.out.println("formato de dni jefe incorrecto");
                      return;
                  }
               }
               Empleado empleado= new Empleado(dni,nombre,apellido1,apellido2,fechaNacimiento,salario,departamento,dniJefeTexto);
               empleados.put(dni,empleado);
           }
        } catch (FileNotFoundException e) {
            System.out.println("La ruta no es un fichero");
            throw new RuntimeException(e);
        }
    }

    private static Date validarFecha(String fechaTexto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        sdf.setLenient(false);
        Date fecha;
        try{
            fecha = sdf.parse(fechaTexto);
        } catch (ParseException e) {
            System.out.println("formato incorrecto de fecha");
            return null;
        }
        return fecha;
    }

    private static boolean comprobarDni(String dni) {
        if (dni.length() != 9){return false;}
        String numeroTexto = dni.substring(0,8);
        try {
            int parteNumerica = Integer.parseInt(numeroTexto);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            char letra = dni.charAt(8);
            if (letra != letras.charAt(parteNumerica % letras.length())){return false;}
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static void escribirMenu() {
        System.out.println("""
                GESTOR EMPLEADOS
                1. Importar empleados
                2. Añadir empleado
                3. Modificar empleado
                4. Eliminar empleado
                5. Exportar empleados
                0. Salir
                Escoja una opción:\s
                """);
    }
}
