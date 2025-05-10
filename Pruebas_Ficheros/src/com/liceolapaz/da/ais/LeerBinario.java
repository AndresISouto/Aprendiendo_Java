package com.liceolapaz.da.ais;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LeerBinario {

	public static void main(String[] args) 
	{
		
		ObjectInputStream  input = null; 
		
		double numero;
		
		try 
		{
			input = new ObjectInputStream(new FileInputStream("C:\\Users\\srigl\\OneDrive\\Desktop\\DAW\\recursos\\pruebabinaria.dat"));
			
			numero= input.readDouble();
			
			System.out.println(numero);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(input != null)
				{
					input.close();
				}
				
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
			}
		}
	}

}
