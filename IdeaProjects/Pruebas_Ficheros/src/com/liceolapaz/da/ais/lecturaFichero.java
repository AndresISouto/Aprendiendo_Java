package com.liceolapaz.da.ais;

import java.io.*;
//import java.util.Scanner;
public class lecturaFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		final String POR_DEFECTO = "C:\\Users\\srigl\\OneDrive\\Desktop";
		
//		System.out.println("Escriba el nobre del fichero a leer");
//		String fichero = sc.nextLine();
//		
//		if (fichero.isEmpty()) 
//		{
//			fichero= POR_DEFECTO;
//		}
		try 
		{
				BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\srigl\\OneDrive\\Desktop\\cosas.txt"));
				
				int lectura = reader.read();
				
				while(lectura != -1)	
				{
					System.out.print((char)lectura);
					
					lectura = reader.read();
				}
				reader.close();
		} 
			
		catch (Exception e) 
		{
				
				e.printStackTrace();
		}
		
	}

}
