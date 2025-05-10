package com.liceolapaz.daw.ais;

public class Texto 
{
	public Texto(String string, int tamanhoMax) {
		super();
		this.tamanhoMax = tamanhoMax;
		if (string.length() < tamanhoMax) {
			
		this.string = string;
		}
		else {
			System.out.println("introduce una cadena menor al tamanño maximo establecido");
		}
		
	}
	
	private String string;
	private int tamanhoMax;
	
	public void caracterInicio(char caracter)
	{
		if (string.length() < tamanhoMax-1) {
			string += caracter;
		}
		else {
			System.out.println("La cadena no admite mas caracteres");
		}
	}
	public void caracterFinal(char caracter)
	{
		if (string.length() < tamanhoMax-1) {
			string = caracter + string;
		}
		else {
			System.out.println("La cadena no admite mas caracteres");
		}
	}
	public void stringInicio(String string)
	{
		if (this.string.length() + string.length() <= tamanhoMax-1) {
			this.string += string;
		}
		else {
			System.out.println("La cadena no admite mas caracteres");
		}
	}
	
	public void stringFinal(String string)
	{
		if (this.string.length() + string.length() <= tamanhoMax-1) {
			this.string = string + this.string;
		}
		else {
			System.out.println("La cadena no admite mas caracteres");
		}
	}
	public void vocales()
	{
		int contador = 0;
		for (int i = 0; i < string.length(); i++) 
		{
			switch (string.charAt(i)) 
			{
			case 'a': case 'A': case 'á': case 'e': case 'E': case 'é': case 'i': case 'I': case 'í':
			case 'o': case 'O': case 'ó': case 'u': case 'U': case 'ú': case 'ü': 
				contador += 1;
				 
				break;

			default:
				break;
			}
				
			
		}
		System.out.println("Numero de vocales: "+contador);
	}
}

