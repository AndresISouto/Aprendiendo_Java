package com.liceolapaz.da.ais;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DobleABinario {

	public static void main(String[] args) 
	{
		double numero;
		ObjectOutputStream out = null;
		
		System.out.println("Escribe un numero a almecenar: ");
		
		numero =leerDouble();
		
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\pruebabinaria.dat") );
			
			out.writeDouble(numero);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		finally {
			
				try 
				{
					if (out != null) 
					{
						out.close();
					}
				} 
					
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Gracias");
		}
		
		
		

	}

	private static double leerDouble() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}

}
