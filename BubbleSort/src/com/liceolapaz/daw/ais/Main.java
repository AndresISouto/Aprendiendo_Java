package com.liceolapaz.daw.ais;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int[] numeros = new int[10];
		int posicion =0;
		int numero;
		Scanner scanner = new Scanner(System.in);
		
		
		while (posicion <10) {
			System.out.print("Introduce un numero positivo");
			numero = scanner.nextInt();
			
			if(numero >=0)
			{
				numeros[posicion]=numero;
				posicion++;
			}
			else {
				System.out.println("Este numero es negativo, introduce un numero positivo");
			}
				
		}
		for (int i = numeros.length; i >0 ;i--) 
		{
			flotar(numeros, i);
		}
		
		for (int i = 0; i < numeros.length; i++) 
		{
			System.out.print(numeros[i] + " ");
		} 
		
		//Arrays.sort(numeros);	
	}
	private static void flotar(int[] numeros, int tamanho)
	{
		int aux;
		
		for (int i = 0; i < tamanho-1; i++) {+
			
			if(numeros[i]>numeros[i+1])
			{
				aux = numeros[i]; // 3
				numeros[i] = numeros[i+1]; //{1,3,2} -> {1,2,2}
				numeros[i+1] = aux;
			}
		}
	}
	
	
	
	

}
