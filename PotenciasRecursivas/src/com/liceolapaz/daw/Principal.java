package com.liceolapaz.daw;

public class Principal {
	public static void main(String[] args) {
		// Potencias recursivas x^y =x*x^y-1 
		int base =2;
		
		int exponente = 10;
		
		int resultado= potenciaRecursiva(base,exponente);
				
		System.out.println(resultado);		
		
	}

	private static int potenciaRecursiva(int base, int exponente) {
		// TODO Auto-generated method stub
		//int aux = base;
		if (exponente == 0) {
			return 1;
		}	
		if (exponente == 1) {
			return base;
			
		}
		else {
			return base * potenciaRecursiva(base, exponente-1) ;
		}
		
	}
}



