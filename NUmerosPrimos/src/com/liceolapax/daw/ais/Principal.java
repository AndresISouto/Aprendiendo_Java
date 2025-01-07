package com.liceolapax.daw.ais;

public class Principal {
	public static void main(String[] args) {
		// encontrar el siguiente primo a uno dado
		boolean encontrado = false;
		
		int partida=31;
		
		while (!encontrado) 
		{
			for (int i = partida+1; i>0 ; i++) 
			{
				int contador=0;
				for (int j = 2; j < i; j++) 
				{
					int condicion = i%j;
					if (condicion ==0) 
					{
						contador++;
					}
				
					
				}
				if (contador==0 && i!=partida) {
					System.out.println("el numero buscado es: "+i);
					System.exit(0);
				}
				
			}
		}
	}
}
