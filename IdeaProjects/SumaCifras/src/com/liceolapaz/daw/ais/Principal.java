package com.liceolapaz.daw.ais;

public class Principal
{
	public static void main(String[] args) 
	{
		int elementos = 12746;
		System.out.println(sumaCifras(elementos));
	}
	private static int sumaCifras(int elementos)
	{
		if (elementos/10 < 10) 
		{
			return elementos%10;
		}
		return elementos%10 + sumaCifras(elementos/10);
	}
}
