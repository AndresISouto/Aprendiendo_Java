package com.daw.liceolapaz.ais;

import java.io.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion;
    do {
      menu();

      try {
        opcion = leerOpcion();
      } catch (Exception e) {
        opcion = -1;// para que entre en el default si eso
        System.out.println("la opcion tiene que ser un numero entero");
        // se puede hecer con un continue tambien
      }

      switch (opcion) {
        case 1:// leer fichero
          System.out.println("Escribe la ruta del fichero");
          String ruta = sc.nextLine();
          String contenido = leerFicheroTexto(ruta);
          if (contenido != null) {
            System.out.println(contenido);
          }
          break;
        case 2:// copiar fichero
          escribirSubmenu();
          try {
            opcion = leerOpcion();
          } catch (Exception e) {
            opcion = -1;// para que entre en el default si eso
            System.out.println("la opcion tiene que ser un numero entero");
            // se puede hecer con un continue tambien
          }
          switch (opcion) {
            case 1:
              System.out.println("Escriba la ruta del fichero origen");
              String rutaOrigen = sc.nextLine();
              System.out.println("Escriba la ruta del fichero destino");
              String rutaDestino = sc.nextLine();
              String contenidoOrigen = leerFicheroTexto(rutaOrigen);
              if (contenidoOrigen != null) {
                escribirFicheroTexto(contenidoOrigen, rutaOrigen);
              }

              break;
            case 2://
              System.out.println("Escriba la ruta del fichero origen");
              String rutaOrigenBinario = sc.nextLine();
              System.out.println("Escriba la ruta del fichero destino");
              String rutaDestinoBinario = sc.nextLine();
              byte[] contenidoOrigenBinario = leerFicheroBinario(rutaOrigenBinario);

              if (contenidoOrigenBinario != null) {
                escribirFicheroBinario(contenidoOrigenBinario, rutaOrigenBinario);
              }
              break;
            case 0:
              continue;
            default:
              break;
          }
          break;
        case 3:// tree
          System.out.println("introdice la ruta de la carpeta origen");
          String rutaCarpeta = sc.nextLine();
          listarFicheros(rutaCarpeta);
          break;
        case 0:
          System.exit(0);
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (true);
  }

  private static void listarFicheros(String ruta) {
    File carpeta = new File(ruta);
    if (!carpeta.isDirectory()) {
      System.out.println("esto no es una carpeta");
      return;
    }
    File[] ficheros = carpeta.listFiles();
    for (int i = 0; i < ficheros.length; i++) {
      System.out.println(ficheros[i].getName() + "\t" + ficheros[i].length() / 1024 + "KBS");
    }
  }

  private static void escribirFicheroBinario(byte[] contenido, String ruta) {
    try {
      FileOutputStream fos = new FileOutputStream(ruta);
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      bos.write(contenido);
      bos.close();
      fos.close();

    } catch (IOException e) {
      System.out.println("error al escribir ficherok");
    }
  }

  private static byte[] leerFicheroBinario(String ruta) {
    File fichero = new File(ruta);
    if (!fichero.isFile()) {
      System.out.println("la ruta no es valida");
      return null;
    }
    byte[] contenido = new byte[(int) fichero.length()];
    byte[] buffer = new byte[1024];
    int posicion = 0;
    try {
      FileInputStream fis = new FileInputStream(fichero);
      BufferedInputStream bis = new BufferedInputStream(fis);
      int numBytesLeidos = bis.read(buffer);
      while (numBytesLeidos > 0) {
        for (int i = 0; i < numBytesLeidos; i++) {
          contenido[posicion] = buffer[i];
          posicion++;
        }
        numBytesLeidos = bis.read(buffer);
      }
    } catch (FileNotFoundException e) {
      System.out.println("la ruta no existe pero aqui no deberia llegar el programa");
    } catch (IOException e) {

    }

    return contenido;
  }

  private static void escribirFicheroTexto(String contenido, String ruta) {
    try {
      FileWriter fw = new FileWriter(ruta);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      pw.print(contenido);
      pw.close();
      bw.close();
      fw.close();
    } catch (IOException e) {
      System.out.println("error al escribir fichero");
    }
  }

  private static void escribirSubmenu() {
    System.out.println("""
        Tipo de fichero a copiar
        1. Fichero de texto
        2. Fichero binario
        0. Cancelar
        Escoja una opción\s
        """);
  }

  private static String leerFicheroTexto(String ruta) {
    File fichero = new File(ruta);
    if (!fichero.isFile()) {
      System.out.println("La ruta no es un fichero");
      return null;
    }
    String contenido = "";
    try {
      Scanner escaner = new Scanner(fichero);
      while (escaner.hasNextLine()) {
        contenido += escaner.nextLine() + "\n";
      }
    } catch (FileNotFoundException e) {
      System.out.println("no esxiste el fichero");
    }

    return contenido;
  }

  private static int leerOpcion() {
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  private static void menu() {
    System.out.println("""
        FICHEROS
        1. Leer fichero de texto
        2. Copiar fichero
        3. Listar archivos de directorio
        0. Salir
        Escoja una opción:\s
        """);
  }
}
