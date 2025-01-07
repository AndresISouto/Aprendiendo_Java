package com.liceolapaz.da.ais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ListaNombres 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		
		
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1://mostrar
				mostrarFichero();
				break;
			case 2://añadir
				
				comprobaryAnhadir();
				
				break;
			case 0:
				System.exit(0);
				break;

			default:
				break;
			}
		} while (true);
		
		

	}

	private static void comprobaryAnhadir() 
	{
		
		
		try
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Introduce un nombre: ");
			
			String nombre = scanner.nextLine(); // el scanner acaba antes de saltar la linea por lo que da problemas si no se van cerrando
		
			BufferedReader ficherolectura = new BufferedReader(new FileReader("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\prueba.txt"));
		
			BufferedWriter ficheroescritura = new BufferedWriter(new FileWriter("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\prueba.txt",true));
			
			String lectura = ficherolectura.readLine();
			
			
			
			boolean presente = false;
			
			while (lectura != null && presente == false ) 
			{
				
				
				if (lectura.equalsIgnoreCase(nombre)) 
				{
					presente = true;
				}
				
				lectura = ficherolectura.readLine();
				
			}
			
			if(!presente)
			{
				ficheroescritura.newLine();
				ficheroescritura.write(nombre);
			}
			
			ficherolectura.close();
			ficheroescritura.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private static void mostrarFichero() 
	{
		try
		{
			BufferedReader ficherolectura = new BufferedReader(new FileReader("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\prueba.txt"));
		
			// BufferedWriter ficheroescritura = new BufferedWriter(new FileWriter("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\prueba.txt",true));
			
			String lectura = ficherolectura.readLine();
			
			while (lectura != null) 
			{
				System.out.println(lectura);
				
				lectura = ficherolectura.readLine();
				
			}
			
			ficherolectura.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	private static void menu()
	{
		System.out.println("""
				Elije una opción: 
				1:Mostrar nombres
				2:Añadir nombre
				0:Salir
				""");
		
	}

}
