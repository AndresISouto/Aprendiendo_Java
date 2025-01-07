package com.liceolapaz.da.ais;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ListaBinaria {

	public static void main(String[] args) {
		/*Meter numeros en una lista hasta meter uno negativo y luego leerlos */
		
		int numero;
		int contador=0;
		
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		
		try 
		{
			output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\pruebabinaria.dat"));
			
			System.out.println("Escribe un numero: ");
			
			numero = leerint();
			
			while(numero >= 0)
			{
				contador++;
				
				output.writeInt(numero);
				
				System.out.println("Escribe un numero: ");
				
				numero = leerint();
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			try 
			{
				if(output != null) {output.close();}
			} 
			catch (Exception e2) 
			{
				System.out.println(e2.getMessage());
			}
		}
		
		try 
		{
			input = new ObjectInputStream(new FileInputStream("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\pruebabinaria.dat"));
			
			while (contador>0)
			{
				contador--;
				
				numero = input.readInt();
				
				System.out.print(numero+" ");
			}
		} 
		catch (Exception e2) 
		{
			System.out.println(e2.getMessage());
		}
		finally
		{
			try 
			{
				if(input != null) {input.close();}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println();
		System.out.println("Gracias");	
	}

	private static int leerint() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
