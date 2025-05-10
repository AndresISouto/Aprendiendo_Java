package com.liceolapaz.da.ais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copia {

	public static void main(String[] args) {
		
		try 
		{
			BufferedReader ficherolectura = new BufferedReader(new FileReader("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\prueba.txt"));
					
			BufferedWriter ficheroescritura = new BufferedWriter(new FileWriter("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\copia.txt"));
		
			int lectura = ficherolectura.read();
			
			while (lectura  != -1) 
			{
				ficheroescritura.write(lectura);
				
				lectura = ficherolectura.read();
			}
			
			ficheroescritura.close();
			ficherolectura.close();
		
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
