package com.liceo.daw.ais;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gestor {

    static HashMap<Integer,Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            menu();
            try{
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("tiene que intruducir un numero");
                continue;
            }

            switch (opcion){
                case 1://importar archivo
                    imortarUsuarios();
                    break;
                case 2://agregar
                    agregarUsuario();
                    break;
                case 3://modificar
                    System.out.println("Introdce el id del usuario a modificar");
                    int id = Integer.parseInt(sc.nextLine());
                    if (usuarios.containsKey(id)){
                        usuarios.remove(id);
                        agregarUsuario(id);
                    }else {
                        System.out.println("no existe ese usuario");
                    }
                    break;
                case 4://eliminar
                    System.out.println("Introdce el id del usuario a eliminar");
                    int idEliminar = Integer.parseInt(sc.nextLine());
                    if (usuarios.containsKey(idEliminar)){
                        usuarios.remove(idEliminar);
                    }else {
                        System.out.println("no existe ese usuario");
                    }
                    break;
                case 5://exportar
                    exportarUsuarios();
                    break;
                case 0:
                    System.out.println("gracias por usar nuestro programa");
                    System.exit(0);
                    break;
                case 6:
                    System.out.println(usuarios);
                    break;
                default:
                    System.out.println("elija una opcion valida");
                    break;
            }
        }while(true);
    }

    private static void exportarUsuarios() {
            try{
                FileWriter fw = new FileWriter("usuariosExportados");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                String linea = "[";
                pw.println(linea);

                for (Usuario usuario : usuarios.values()){
                    pw.println(usuario);
                }
                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    private static void agregarUsuario(int id) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("introduce el email");
            String mail = sc.nextLine();
            if (!validaEmail(mail)){
                System.out.println("el email no es valido");
                return;
            }

            System.out.println("Introduce el nombre");
            String nombre = sc.nextLine();
            if (nombre.equals("")){
                System.out.println("es obligatorio introducir un nombre");
                return;
            }
            System.out.println("Introduce el apellido");
            String apellido = sc.nextLine();
            if (apellido.equals("")){
                System.out.println("es obligatorio introducir un apellido");
                return;
            }

            System.out.println("Introduce el avatar");
            String avatar = sc.nextLine();
            if (avatar.equals("")){
                System.out.println("es obligatorio introducir un avatar");
                return;
            }

            Usuario usuario = new Usuario(id,mail,nombre,apellido,avatar);
            usuarios.put(id,usuario);
        } catch (NumberFormatException e) {
            System.out.println("error de formato del id (introducir un numero)");
        }
    }

    private static void agregarUsuario() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("introduce el id del usuario");
            int id = Integer.parseInt(sc.nextLine());
            if (usuarios.containsKey(id)){
                System.out.println("este id ya esta usado");
                return;
            }

            System.out.println("introduce el email");
            String mail = sc.nextLine();
            if (!validaEmail(mail)){
                System.out.println("el email no es valido");
                return;
            }

            System.out.println("Introduce el nombre");
            String nombre = sc.nextLine();
            if (nombre.equals("")){
                System.out.println("es obligatorio introducir un nombre");
                return;
            }
            System.out.println("Introduce el apellido");
            String apellido = sc.nextLine();
            if (apellido.equals("")){
                System.out.println("es obligatorio introducir un apellido");
                return;
            }

            System.out.println("Introduce el avatar");
            String avatar = sc.nextLine();
            if (avatar.equals("")){
                System.out.println("es obligatorio introducir un avatar");
                return;
            }

            Usuario usuario = new Usuario(id,mail,nombre,apellido,avatar);
           usuarios.put(id,usuario);
        } catch (NumberFormatException e) {
            System.out.println("error de formato del id (introducir un numero)");
        }
    }

    private static void imortarUsuarios() {
       File fichero = new File("usuarios.txt");
       if (!fichero.isFile()){
           System.out.println("problemas al encontrar el fichero");
           return;
       }
       try {
            Scanner sf = new Scanner(fichero);
            //quitamos la pirmera linea
           String linea = sf.nextLine();
           while (sf.nextLine().equals("  {")){
              linea = sf.nextLine();
              String [] partesID = linea.split(": ");
              String numeroIdTexto = partesID[1].substring(0,partesID[1].length()-1);
              int id = Integer.parseInt(numeroIdTexto);

              linea = sf.nextLine();
              String[] partesEmail = linea.split(": ");
              String mail = partesEmail[1].substring(1,partesEmail[1].length()-2);
             if (!validaEmail(mail)){
                 System.out.println("email no valido");
                 return;
             }

             linea = sf.nextLine();
             String[] partesNombre = linea.split(": ");
             String nombre =  partesNombre[1].substring(1,partesNombre[1].length()-2);


               linea = sf.nextLine();
               String[] partesApellido = linea.split(": ");
               String apellido =  partesApellido[1].substring(1,partesApellido[1].length()-2);


               linea = sf.nextLine();
               String[] partesAvatar = linea.split(": ");
               String avatar =  partesAvatar[1].substring(1,partesAvatar[1].length()-1);

               //descartamos el cierre
               linea = sf.nextLine();

               Usuario usuario = new Usuario(id,mail,nombre,apellido,avatar);
               usuarios.put(id,usuario);
           }

       } catch (FileNotFoundException e) {
           System.out.println("problemas al escanear el fichero");
           return;
       }catch (NumberFormatException e){
           System.out.println("formato incorrecto del numero ");
       }
    }
    public static Boolean validaEmail (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static void menu() {
        System.out.println("""
                GESTOR USUARIOS
                1. Importar usuarios
                2. Añadir usuario
                3. Modificar usuario
                4. Eliminar usuario
                5. Exportar usuarios
                0. Salir
                Escoja una opción:\s
                """);
    }
}
