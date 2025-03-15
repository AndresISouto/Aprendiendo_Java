package com.liceolapaz.daw.ais;

public class Principal 
{
	public static void main(String[] args) 
	{
		// pedir un numero y hacer una torre de tantos niveles 
		/*La torre la haremos imprimiendo el valor de en medio y a la derecha su cadena descendiente y a la izquierda ascendente*/
		int centro = 9;
		for (int i = 1; i < centro+1; i++)
		{
			System.out.print(espaciado(centro -i));
			System.out.println(nivelTorre(i));
		}
		
	}
	private static String cadenaAscendente(int centro)
	{
		String cadena ="";
		for (int i =1; i < centro; i++) 
		{
			cadena +=i;
		}
		return cadena;
	}
	private static String revertirCadena(String cadenaAInvertir) 
	{
		String auxString = "";
		for (int i = 0; i < cadenaAInvertir.length(); i++) 
		{
			auxString =cadenaAInvertir.charAt(i) + auxString;
		}
		return auxString;
	}
	private static String nivelTorre(int centro) 
	{
		return cadenaAscendente(centro) + centro + revertirCadena(cadenaAscendente(centro));
	}
	private static String espaciado(int nEspacios) 
	{
		String auString = "";
		for (int i = 0; i < nEspacios; i++)
		{
			auString += " ";
		}
		return auString;
	}
}
