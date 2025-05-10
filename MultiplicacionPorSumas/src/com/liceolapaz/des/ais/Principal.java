package com.liceolapaz.des.ais;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int x,y;
		
		System.out.println("introduce los dos numeros a multiplicar separados por una coma");
		
		String sdatoString = leer();
		
		System.out.println(sdatoString);
		
		String[] parteString = sdatoString.split(",");
		
		
		x = Integer.parseInt(parteString[0]);
		y = Integer.parseInt(parteString[1]);
		
		
		int i = 1;
		int aux = x;
		
		if (y !=0) {
			while (i < y) {
				x = x+  aux;
				i++;

			} 
			System.out.println("el resultado es: "+x);
		}
		else {
			System.out.println("El resultado es 0");
		}
		
		
			
	}
	 private static String leer() {
		 Scanner scanner = new Scanner(System.in);
		 return scanner.nextLine();
	 }

}
