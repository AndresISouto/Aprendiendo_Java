package com.liceolapaz.da.ais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Matriz {

	public static void main(String[] args) 
	{
		int [] fila ;
		int[][] matriz = null;
		
		try 
		{
			BufferedReader ficherolectura = new BufferedReader(new FileReader("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\prueba.txt"));
		
			String lectura = ficherolectura.readLine();
			
			while (lectura != null &&  !lectura.isEmpty())
			{
				fila = extraerFila(lectura);
				
				matriz = insertarFila(matriz,fila);
				
				lectura = ficherolectura.readLine();
				
			}
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[0].length; j++) {
					System.out.print(matriz[i][j]+" ");
				}
				System.out.println();
			}
		
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static int[][] insertarFila(int[][] matriz, int[] fila) {
		
		int[][] aux =null;
		
		if (matriz == null ) 
		{
			matriz = new int[1][fila.length];
			
			
			matriz[0] = fila;
		}
		
		else 
		{
		aux = new int[matriz.length][matriz[0].length];
		
			for (int i = 0; i < matriz.length; i++) 
			{
				for (int j = 0; j < matriz[0].length; j++) 
				{
				aux[i][j] = matriz[i][j];
				
				}
			
			}
			
			
			matriz = new int[matriz.length+1][fila.length];
			
			for (int i = 0; i < aux.length; i++) 
			{
				for (int j = 0; j < aux[0].length; j++) 
				{
					matriz[i][j] = aux[i][j];
				}
			}
			
			matriz[matriz.length-1] = fila;
			
		}
		
		
		
		
		return matriz;
	}

	private static int[] extraerFila(String lectura) {
		
		String[] separador =lectura.split(" ");
		
		int[] fila = new int[separador.length];
		
		for (int i = 0; i < fila.length; i++) 
		{
			fila[i] = Integer.parseInt(separador[i]) ;
		}
		
		return fila;
	}

	
	

}
