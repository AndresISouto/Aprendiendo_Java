package com.liceolapaz.daw.ais;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*Pedir un dia el mes y sacar el siguiente, no usaremos la movida del time porque no  ayuda a aprender*/
		
		/*Ahora modificaremos este ejercicio para calcular pasados n dias,
		 * hay que tener en cuenta que podemos avanzar varios meses a la vez
		 * 		por lo que hay que ver cuantos messes pasan y ver si llegan a un nuevo mes
		 * dia + n si se pasa de mes avanzamos de mes y comprobamos con el mes siguiente
		 * dia +n - diasmes < diasmes+1? --> sacamos un while hasta que lo tengamos,
		 * lo malo es que se nos puede ir ge rango, pero podemos calcular el acumulativo para ver que no se sale del año y volver*/
		
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("introduce el día");
			int dia = sc.nextInt();
			System.out.println("introduce el mes en formato numerico");
			int mes = sc.nextInt();
			System.out.println("introduce el numero de dias a avanzar");
			int n = sc.nextInt();
			
			if (dia > diasMes(mes)) {
				System.out.println("Esta fecha no es valida, vuelve a introducir otra");
			
			} 
			else {
				int[] fechaDiaSiguiente = diaSiguiente(dia, mes, n);
				System.out.printf("La fech siguiente es dia: %d mes: %d \n",fechaDiaSiguiente[1],fechaDiaSiguiente[0]);
			}
			
		} while (true);
		
		
	}

	private static int diasMes(int mes)
	{
		int[] diasPorCadaMes= new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		
		return diasPorCadaMes[mes-1];
	}
	private static int diasMesAcumulativo(int mes) {
		
		int[] diasPorCadaMes= new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		int aux=0;
		for (int i=0 ; i<mes; i++) {
			aux += diasPorCadaMes[i] ;
		}
		return aux;
	}
	private static int[] diaSiguiente(int dia, int mes, int n)
	{
		if (dia + n+ diasMesAcumulativo(mes) > 365) {
			System.out.println("te has pasado de año, por favor mantente en este año");
			System.exit(0);
			
		}
		
		if (dia+n < diasMes(mes) ) {
			
			return new int[] {mes,dia+n};
		}
		else {
			int sobrecarga=dia+n - diasMes(mes);
			int i =1;
			while (sobrecarga > diasMes(mes+i)) {
				sobrecarga -= diasMes(mes+i);
				i++;					
			}
			return new int[] {mes+i ,sobrecarga};
		}
		
//		else {
//			int[] aux = new int[] {mes+1,1};
//			return aux;
//		}
	}

}
