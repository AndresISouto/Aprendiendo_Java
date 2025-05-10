package com.liceo.daw.ais;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gestor {
   static HashMap<Integer,Departamento> departamentos = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
       menu();
       try{
           opcion = Integer.parseInt(sc.nextLine());
       } catch (NumberFormatException e) {
           System.out.println("Es necesario escribir un numero");
           continue;
       }
       switch (opcion){
           case 1://importar
               importarDepartamentos();
               break;
           case 2://agregar departamento;
               agregarDepartamento();
               break;
           case 3://modificar departamento
               System.out.println("introduce el numero del departamento a modificar");
               int num_departamento = Integer.parseInt(sc.nextLine());
               if (departamentos.containsKey(num_departamento)){
                  departamentos.remove(num_departamento);
                  agregarDepartamento(num_departamento);
               }else {
                   System.out.println("no existe ese departamento");
               }
               break;
           case 4://eliminar
               System.out.println("introduce el numero del departamento a modificar");
               int num_departamento2 = Integer.parseInt(sc.nextLine());
               if (departamentos.containsKey(num_departamento2)){
                   departamentos.remove(num_departamento2);
               }else {
                   System.out.println("no existe ese departamento");
               }
               break;
           case 5://exportar
               exportarDatos();
               break;
           case 6:
               System.out.println(departamentos);
               break;
           case 0:
               System.out.println("gracias por usar este programa");
               System.exit(0);
               break;
           default:
               System.out.println("opcion no valida");
               break;
       }

        }while(true);
    }

    private static void exportarDatos() {
        try {
            FileWriter fw = new FileWriter("exportData.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String linea =" num_depto;nombre;nombre_corto;planta;cif_director;correo_e";
            pw.println(linea);

            for (Departamento departamento : departamentos.values()){
                pw.println(departamento);
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void agregarDepartamento(int num_departamento) {
        Scanner sc = new Scanner(System.in);

        try{

            System.out.println("introduce el nombre");
            String nombre = sc.nextLine();
            System.out.println("introduce el nombre corto");
            String nombre_corto = sc.nextLine();

            System.out.println("introduce el numero de planta");
            String plantaTexto = sc.nextLine();
            int planta = Integer.parseInt(plantaTexto);

            System.out.println("introduce el cif del director");
            String cif_director = sc.nextLine();
            if (!validarCif(cif_director)){
                System.out.println("el cif del director no es valido");
                return;
            }

            System.out.println("introduce el correo");
            String correo = sc.nextLine();
            if (!validaEmail(correo)){
                System.out.println("el correo no es valido");
                return;
            }
            Departamento departamento = new Departamento(num_departamento,nombre,nombre_corto,planta,cif_director,correo);
            departamentos.put(num_departamento,departamento);
        } catch (Exception e) {
            System.out.println("error al introducir los datos");
        }
    }

    private static void agregarDepartamento() {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("introduce el numero de departamento");
            String num_departementoTexto = sc.nextLine();
            int num_departamento = Integer.parseInt(num_departementoTexto);
            if (departamentos.containsKey(num_departamento)){
                System.out.println("departamento ya existente");
                return;
            }

            System.out.println("introduce el nombre");
            String nombre = sc.nextLine();
            System.out.println("introduce el nombre corto");
            String nombre_corto = sc.nextLine();

            System.out.println("introduce el numero de planta");
            String plantaTexto = sc.nextLine();
            int planta = Integer.parseInt(plantaTexto);

            System.out.println("introduce el cif del director");
            String cif_director = sc.nextLine();
            if (!validarCif(cif_director)){
                System.out.println("el cif del director no es valido");
                return;
            }

            System.out.println("introduce el correo");
            String correo = sc.nextLine();
            if (!validaEmail(correo)){
                System.out.println("el correo no es valido");
                return;
            }
            Departamento departamento = new Departamento(num_departamento,nombre,nombre_corto,planta,cif_director,correo);
            departamentos.put(num_departamento,departamento);
        } catch (Exception e) {
            System.out.println("error al introducir los datos");
        }
    }

    private static void importarDepartamentos() {
        File fichero = new File("departamentos.txt");
        if (!fichero.isFile()){
            System.out.println("El fichero no se ha podido localizar correctamente");
            return;
        }
        try{
            Scanner sf = new Scanner(fichero);
            //descartamos la primera linea
            String linea = sf.nextLine();

            while (sf.hasNextLine()){
                linea = sf.nextLine();
                String valores[] = linea.split(";");

                String num_departementoTexto = valores[0];
                int num_departamento = Integer.parseInt(num_departementoTexto);

                String nombre = valores[1];
                String nombre_corto = valores[2];

                String plantaTexto = valores[3];
                int planta = Integer.parseInt(plantaTexto);

                String cif_director = valores[4];
                if (!validarCif(cif_director)){
                    System.out.println("el cif del director no es valido");
                    return;
                }

                String correo = valores[5];
                if (!validaEmail(correo)){
                    System.out.println("el correo no es valido");
                    return;
                }
                Departamento departamento = new Departamento(num_departamento,nombre,nombre_corto,planta,cif_director,correo);
                departamentos.put(num_departamento,departamento);
            }
        } catch (FileNotFoundException e) {
            System.out.println("problemas al encontrar el fichero");
        }catch (NumberFormatException ne){
            System.out.println("error en el formato de los numeros");
        }



    }
    public static Boolean validaEmail (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validarCif(String dni) {

        if (dni.length() != 10){return false;}
        String numeroTexto = dni.substring(0,8);
        try {
            int parteNumerica = Integer.parseInt(numeroTexto);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            char letra = dni.charAt(9);
            if (letra != letras.charAt(parteNumerica % letras.length())){return false;}
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    private static void menu() {
        System.out.println("""
                GESTOR DEPARTAMENTOS
                1. Importar departamentos
                2. Añadir departamento
                3. Modificar departamento
                4. Eliminar departamento
                5. Exportar departamentos
                0. Salir
                Escoja una opción:\s
                """);
    }
}
