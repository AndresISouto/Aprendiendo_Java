package com.liceolapaz.da.ais;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritura_Fichero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("edad: ");
		String edad = sc.nextLine();
		
		try 
		{
			BufferedWriter  fichero = new BufferedWriter(new FileWriter("prueba.txt"));
		
			fichero.write("Nombre: "+nombre);
			
			fichero.newLine();
			
			fichero.write("edad: "+edad);
			
			fichero.close();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
