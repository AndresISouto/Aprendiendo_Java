package com.liceolapaz.daw.ais;

import java.util.Arrays;
import java.util.Random;

public class MaxSubarray {

	public static void main(String[] args) 
	{
		Random random = new Random();
		
		int ln = random.nextInt(9,10);
		
		int[] numeros = new int[ln];
		
		for (int i = 0; i < numeros.length; i++) 
		{
			numeros[i]=random.nextInt(-10,10);
		}
	
		int[] posicionesSuma = SubArrayFuerzaBruta(numeros);
		
		int[] kadano = SubArrayKadano(numeros);
		
		
		
		System.out.println("Nuestro array de longitud "+ln+" es:");
		
		for (int i = 0; i < numeros.length; i++) 
		{
			System.out.print(numeros[i] + " ");
		}
		
		System.out.printf("\n La sub suma máxima de este array es: %d entre las posiciones %d y %d \n"
				,posicionesSuma[2],posicionesSuma[0],posicionesSuma[1]);
		System.out.printf("\n La sub suma máxima de este array es: %d entre las posiciones %d y %d"
				,kadano[2],kadano[0],kadano[1]);
	}

	private static int[] SubArrayKadano(int[] numeros) {
		int[] kadano = new int[3];
		int suma = 0;
		int maxSuma = 0;
		for (int i = 0; i < numeros.length; i++) 
		{
			
			suma += numeros[i];
			
			if (suma < 0) {suma = 0;}
			
			maxSuma = Math.max(maxSuma, suma);
			
			kadano[2] = maxSuma;
			
			if(suma == maxSuma){kadano[1]=i;}
		}

		return kadano;
	}

	private static int[] SubArrayFuerzaBruta(int[] numeros) 
	{
		int maxSuma = 0;
		int localSuma=0;
		int[] posicionesSuma = new int[3];
		
		for (int i = 0; i < numeros.length; i++) 
		{
			localSuma = numeros[i]; 
			maxSuma = Math.max(localSuma, maxSuma);
			if (localSuma == maxSuma) 
			{
				posicionesSuma[0] = i;
				posicionesSuma[1] = i;
				posicionesSuma[2] = maxSuma;
			}
			for (int j = i+1; j < numeros.length; j++) 
			{
				localSuma += numeros[j];
				maxSuma = Math.max(localSuma, maxSuma);
				if (localSuma == maxSuma) 
				{
					posicionesSuma[0] = i;
					posicionesSuma[1] = j;
					posicionesSuma[2] = maxSuma;
				}
			}
		}
		
		return posicionesSuma;
	}

}
