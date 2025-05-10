package com.liceolapaz.daw.ais;
import java.util.HashMap;

//TODO: calcular el valor

public class NumerosRomanos {
	/*Vamos a hacer un programa que pase de numeros romanos a decimales, primero tenemos que crear una relación 1:1 entre números y caracteres
	 * 	que haremos con un hashMap.
	 *Luego tendremos que ver que reglas aplican a la conversión de valores con la resta entre números consecutivos
	 *	sabemos que si un numero va antes que otro mayor el primero restará al segundo 
	 *	vamos a comprobar en papel si puede haber una escalera de números asecendentes
	 *		tras experimentar vemos que las restas van en pares de 2 y que solo restan a las dos figuras siguientes
	 *Tendremos que ver si el numero introduccido es correcto
	 *	supongo que podremos poner los caracteres en una cadena y ver si el caracter está seguido de otro varias ordenes mayor
	 *	tendremos que comprobar todos hasta el último */

	public static void main(String[] args) 
	{
				
		HashMap<Character, Integer> valorNumero = new HashMap<Character, Integer>();
		
		valorNumero.put('i', 1);
		valorNumero.put('v', 5);
		valorNumero.put('x', 10);
		valorNumero.put('l', 50);
		valorNumero.put('c', 100);
		valorNumero.put('d', 500);
		valorNumero.put('m', 1000);
		

		String numeroRomano = "cccxiv";
		
		
		if(comprovarValidez(numeroRomano,valorNumero)) {
			System.out.println(valor(numeroRomano,valorNumero));		
		}
		else {
			System.out.println("valor no válido");
		}
		
			
	}


	private static int valor(String numeroRomano, HashMap<Character, Integer> valorNumero) 
	{
		int resultado=0;
		for (int i = 0; i < numeroRomano.length(); i++) 
		{
			if (i< numeroRomano.length()-1 && valorNumero.get(numeroRomano.charAt(i)) < valorNumero.get(numeroRomano.charAt(i+1)) )
			{
				resultado = resultado - valorNumero.get(numeroRomano.charAt(i));
			}
			else 
			{
				resultado += valorNumero.get(numeroRomano.charAt(i));
			}
		}
		
		
		return resultado;
	}


	private static boolean comprovarValidez(String numeroRomano, HashMap<Character, Integer> valorNumero) 
	{
		
		
		for (int i = 0; i < numeroRomano.length(); i++) 
		{
			if (! valorNumero.containsKey(numeroRomano.charAt(i)))
			{
				return false;
			}
		}
		
		for (int i = 0; i < numeroRomano.length()-1; i++) 
		{
					
			 if (numeroRomano.charAt(i) == 'i' || numeroRomano.charAt(i) == 'x' || numeroRomano.charAt(i) == 'c') 
			{
				if (numeroRomano.charAt(i) == numeroRomano.charAt(i+1)) 
				{
					if (numeroRomano.length() >= i+4
							&& numeroRomano.charAt(i) == numeroRomano.charAt(i+1)
							&& numeroRomano.charAt(i) == numeroRomano.charAt(i+2)
							&& numeroRomano.charAt(i) == numeroRomano.charAt(i+3)) 
					{
						return false;
					}
				}
				
				if (valorNumero.get(numeroRomano.charAt(i)) < valorNumero.get(numeroRomano.charAt(i+1)))
				{
					
					if (5 * valorNumero.get(numeroRomano.charAt(i)) != valorNumero.get(numeroRomano.charAt(i+1)) 
							&& 10 * valorNumero.get(numeroRomano.charAt(i)) != valorNumero.get(numeroRomano.charAt(i+1))) 
					{
						
						return false;
					}
				}
			}
					
				if (numeroRomano.charAt(i) == 'v' || numeroRomano.charAt(i) == 'l' || numeroRomano.charAt(i) == 'd') 
				{
					if(valorNumero.get(numeroRomano.charAt(i)) < valorNumero.get(numeroRomano.charAt(i+1))) 
					{
						return false;
					}
				}
					
				if (numeroRomano.charAt(i) == 'm') 
				{
					if (numeroRomano.charAt(i) == numeroRomano.charAt(i+1)) 
					{
						if (numeroRomano.length() >= i+4
								&& numeroRomano.charAt(i) == numeroRomano.charAt(i+1)
								&& numeroRomano.charAt(i) == numeroRomano.charAt(i+2)
								&& numeroRomano.charAt(i) == numeroRomano.charAt(i+3)) 
						{
							return false;
						}
					}
				}
				
				
			}
		
		return true;
	}
}


			
			
			
			
			




