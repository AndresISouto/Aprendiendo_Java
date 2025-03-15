package com.liceolapaz.daw.ais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Principal { //Poniendo todo a HashSet se arregla ya que no se pueden repetir pero no me convence

	static final int  NUMELEMENTOS = 100;
	static int contador=0;
	public static void main(String[] args) 
	{
		int[] elementos = new int[NUMELEMENTOS];
		Random random = new Random();
		for (int i = 0; i < elementos.length; i++) 
		{
			elementos[i] = random.nextInt(1, elementos.length);
		}
		Arrays.sort(elementos);
		int inicio = 0;
		int fin = elementos.length-1;
		int objetivo = random.nextInt(1, NUMELEMENTOS);
		//int[] pareja = dosSumas(elementos, inicio, fin, objetivo); esto para cuando solo queriamos 1
		ArrayList<Integer[]> paresValidos = dosSumas( elementos,  inicio,  fin,  objetivo);
		//System.out.println("Para llegar al número objetivo: " + objetivo + " se suman los números: " + pareja[0]+ " " +pareja[1]);
		System.out.println("Las parejas válidas que suman el objetivo: "+objetivo+" son:");
		for (Integer[] i : paresValidos) //Ni puta idea de por que no iva antes
		{
			System.out.print(Arrays.asList(i)+" ");
		}
		
		//esto va pero no se por que no la otra asi que toca probar
//		for (int i = 0; i < paresValidos.size(); i++) 
//		{
//			System.out.print(Arrays.asList(paresValidos.get(i)));
//		}
	}
	
	private static ArrayList<Integer[]> dosSumas(int[] elementos, int inicio, int fin, int objetivo)
	{
		ArrayList<Integer[]> auxiliar = new ArrayList<Integer[]>();
		Integer[] soporteIntegers;
		
		while(inicio < fin) 
		{
			if (elementos[inicio] + elementos[fin] == objetivo) 
			{
				soporteIntegers = new Integer[] {elementos[inicio],elementos[fin]};
				if (! auxiliar.contains(soporteIntegers))
				{
					auxiliar.add(soporteIntegers);
				}
				
				fin--;
				
			}
			else if (elementos[inicio] + elementos[fin] < objetivo) 
			{
				inicio++;
			}
			else if (elementos[inicio] + elementos[fin] > objetivo) 
			{
				fin--;
			}

			
		}
		if (auxiliar.isEmpty()) 
		{
			System.out.println(" No se ha encontrado pareja posible que sume ese numero");
		}
		return auxiliar ;

	}
}
