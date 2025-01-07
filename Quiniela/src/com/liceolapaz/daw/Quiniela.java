package com.liceolapaz.daw;

import java.util.Random;

public class Quiniela 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		int[] quiniela = new int[6];
		
		for (int i = 0; i < quiniela.length; i++) 
		{
			quiniela[i] = random.nextInt(1, 100);
			for (int j = i; j > 0 ; j--) 
			{
				if (quiniela[i] == quiniela[j-1]) 
				{
					i--;
				}
			}
		}
		 for (int i = 0; i < quiniela.length; i++) {
			System.out.print(quiniela[i]+" ");
		}	
	}
}
