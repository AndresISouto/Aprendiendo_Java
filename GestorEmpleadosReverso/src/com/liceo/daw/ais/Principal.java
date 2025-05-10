package com.liceo.daw.ais;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    static HashMap<String,Empleado> empleados = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            System.out.println("Selecciona una opcion");
            try{
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("tiene que introducir un numero");
                continue;
            }
            switch (opcion){
                case 1://importar fichero
                    importarFichero();
                    break;
                case 2:// add empleado
                    agregarEmpleado();
                    break;
                case 3:// modificar empleado
                    System.out.println("dni del empleado a modificar");
                    String dni = sc.nextLine();
                    if (empleados.containsKey(dni)){
                        empleados.remove(dni);
                        agregarEmpleado(dni);
                    }
                    else {
                        System.out.println("no existe tal empleado");
                    }
                    break;
                case 4://eliminar
                    System.out.println("dni del empleado a eliminar");
                    String dniEliminar = sc.nextLine();
                    if (empleados.containsKey(dniEliminar)){
                        empleados.remove(dniEliminar);
                    }
                    else {
                        System.out.println("no existe tal empleado");
                    }
                    break;
                case 5://exportar
                    exportarEmpleados();
                    break;
                case 0:
                    System.out.println("gracias por usar este programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Introuduzca una opcion valida");
                    break;
            }
        }while(true);
    }

    private static void exportarEmpleados() {
        try {
            FileWriter fw = new FileWriter("empleados.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String linea =  "(DNI, Nombre, Primer_Apellido, Segundo_Apellido, Fecha_Nacimiento, Salario, Departamento, DNI_Jefe)";
            pw.println(linea);

            for (Empleado empleado : empleados.values()){
                pw.println(empleado);
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void agregarEmpleado(String dni) {
    try {
        Scanner sf = new Scanner(System.in);

        System.out.println("introduce el nombre del empleado");
        String nombre= sf.nextLine();

        System.out.println("introduce el apellido 1 del empleado");
        String apellido1= sf.nextLine();

        System.out.println("introduce el segundo apellido");
        String apellido2= sf.nextLine();
        if (apellido2.equals("null")){
            apellido2 = null;
        }
        System.out.println("introduce la fecha yyyy/m/d");
        String fechaNacimientoTexto = sf.nextLine();
        Date fechaNacimiento = formatDate(fechaNacimientoTexto);

        System.out.println("salario");
        String salarioTexto = sf.nextLine();
        double salario = Double.parseDouble(salarioTexto);

        System.out.println("departamento");
        String departamentoTexto = sf.nextLine();
        int departamento = Integer.parseInt(departamentoTexto);

        System.out.println("dni jefe");
        String dniJefe= sf.nextLine();
        if (dniJefe.equals("null")){
            dniJefe = null;
        }
        else if (!validarDni(dniJefe)){
            System.out.println("dni del jefe no valido");
        }
        Empleado empleado = new Empleado(dni,nombre,apellido1,apellido2,fechaNacimiento,salario,departamento,dniJefe);
        empleados.put(dni,empleado);
    } catch (Exception e) {
        System.out.println("algun problema de formato ");
    }
}
    private static void agregarEmpleado() {
        try {
        Scanner sf = new Scanner(System.in);
            System.out.println("introduce el dni del empleado");
            String dni= sf.nextLine();
            if (!validarDni(dni)){
                System.out.println("dni no valido");
                return;
            }
            System.out.println("introduce el nombre del empleado");
            String nombre= sf.nextLine();

            System.out.println("introduce el apellido 1 del empleado");
            String apellido1= sf.nextLine();

            System.out.println("introduce el segundo apellido");
            String apellido2= sf.nextLine();
            if (apellido2.equals("null")){
                apellido2 = null;
            }
            System.out.println("introduce la fecha yyyy/m/d");
            String fechaNacimientoTexto = sf.nextLine();
            Date fechaNacimiento = formatDate(fechaNacimientoTexto);

            System.out.println("salario");
            String salarioTexto = sf.nextLine();
            double salario = Double.parseDouble(salarioTexto);

            System.out.println("departamento");
            String departamentoTexto = sf.nextLine();
            int departamento = Integer.parseInt(departamentoTexto);

            System.out.println("dni jefe");
            String dniJefe= sf.nextLine();
            if (dniJefe.equals("null")){
                dniJefe = null;
            }
            else if (!validarDni(dniJefe)){
                System.out.println("dni del jefe no valido");
                return;
            }
            Empleado empleado = new Empleado(dni,nombre,apellido1,apellido2,fechaNacimiento,salario,departamento,dniJefe);
            empleados.put(dni,empleado);
        } catch (Exception e) {
            System.out.println("algun problema de formato ");
            return;
        }
    }

    private static void importarFichero() {
        System.out.println("el fichero se toma directamente de la carpeta del proyecto");
        File fichero = new File("listado_empleados.txt");
        if (!fichero.isFile()){
            System.out.println("ha habido un error con el fichero");
            return;
        }
        try{
            Scanner sf = new Scanner(fichero);
            String linea;
            //Descartamos las 3 primeras lineas
           linea = sf.nextLine();
            linea = sf.nextLine();
            linea = sf.nextLine();
            while (sf.hasNextLine()){
                //descartamos 3 lineas
                linea = sf.nextLine();
                linea = sf.nextLine();
                linea = sf.nextLine();

                String dniTexto = sf.nextLine();
                String dni = dniTexto.substring(5);
                if (!validarDni(dni)){
                    System.out.println("dni no valido");
                    return;
                }
                String nombreTexto = sf.nextLine();
                String nombre =nombreTexto.substring(8);

                String apellido1Texto = sf.nextLine();
                String apellido1 = apellido1Texto.substring(17);

                String apellido2Texto = sf.nextLine();
                String apellido2 = apellido2Texto.substring(18);
                if (apellido2.equals("null")){
                    apellido2 = null;
                }
                String fechaNacimientoTexto = sf.nextLine();
                Date fechaNacimiento = formatDate(fechaNacimientoTexto.substring(21));

                String salarioTexto = sf.nextLine();
                double salario = Double.parseDouble(salarioTexto.substring(9));

                String departamentoTexto = sf.nextLine();
                int departamento = Integer.parseInt(departamentoTexto.substring(24));

                String dniJefeTexto = sf.nextLine();
                String dniJefe = dniJefeTexto.substring(10);
                if (dniJefe.equals("null")){
                    dniJefe = null;
                }
                else if (!validarDni(dniJefe)){
                    System.out.println("dni del jefe no valido");
                   return;
                }
                Empleado empleado = new Empleado(dni,nombre,apellido1,apellido2,fechaNacimiento,salario,departamento,dniJefe);
                empleados.put(dni,empleado);
            }
        } catch (FileNotFoundException e) {

        }

    }

    private static Date formatDate(String fechaNacimientoTexto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        sdf.setLenient(false);
        Date fecha;
        try {
       fecha = sdf.parse(fechaNacimientoTexto);
        } catch (ParseException e) {
            System.out.println("error de formato de fecha");
            throw new RuntimeException(e);
        }
        return fecha;
    }

    private static boolean validarDni(String dni) {

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


    private static void menu() {
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
