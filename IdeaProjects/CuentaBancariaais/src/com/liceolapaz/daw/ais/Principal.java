package com.liceolapaz.daw.ais;

import java.util.Scanner;

public class Principal {
	private static double saldo = 0;
	private static boolean entradaCreada = false;
	private static boolean premium = false;
	
	public static void  main(String[] args) {
		
		int op;
		
		do {
			//mostramos el primer menu de banca
			menu();
			op = leerInt();	
			switchBanca(op);
		}while(true);

	}
	private static void switchBanca(int op) {
		// TODO Auto-generated method stub
		switch(op) {
		case 1: //crear cuenta
			menuCuenta(); //muestra menu cuenta
			op = leerInt(); //almacena el dato
			switchCuenta(op);//aplica el resultado		
			break;
		case 2://ingresar
			if (!entradaCreada) {
				System.out.print("Tiene que crear una cuenta primero para poder operar\n");
			}
			else {
				System.out.print("Indica la cantidad que quiere ingresar\n");
				double ingreso = leerDouble();
				saldo += ingreso;
				System.out.print("Su saldo final es de " +  saldo + "\n");
			}
			
			break;
		case 3: //retirar
			if (!entradaCreada) {
				System.out.print("Tiene que crear una cuenta primero para poder operar \n");
			}
			else {
				System.out.print("Indica la cantidad que quiere retirar \n");
				double retirada = leerDouble();
				if (retirada > saldo && !premium) {
					System.out.print("Esta operacion no es valida, por favor, contrate una cuenta premium para irse a saldos negativos \n");
				}
				else {
					saldo -= retirada;
					System.out.print("Su saldo final es de " + saldo + "\n");
				}
			}
			break;
		case 4: //consultar
			if (!entradaCreada) {
				System.out.print("Tiene que crear una cuenta primero para poder operar \n ");
			}
			else {
				System.out.print("Su saldo  es de " + saldo + "\n");
			}
			break;
		case 0:
			System.out.print("Gracias por usar esta aplicación");
			System.exit(0);
			break;
		default:
			System.out.print("Por favor introduzca un comando correcto \n");
			break;
			
		}
	}
	private static void switchCuenta(int op) {
		
		switch(op) {
		case 1:
			System.out.print("Indica el saldo inicial");
			saldo = leerDouble();
			entradaCreada = true;
			premium = false;
			break;
		case 2:
			System.out.print("Indica el saldo inicial");
			saldo = leerDouble();
			entradaCreada = true;
			premium = true;
			break;
		case 0:
			break;
		default:
			System.out.print("Por favor, use un valor valido \n ");
			break;
		}
	}
	private static int leerInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	private static double leerDouble() {
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	// muestra un menu
	private static void menu() {
		System.out.print("BANCO \n1.Crear Cuenta \n2.Ingresar dinero"
				+ " \n3.Retirar Dinero \n4.Consultar Saldo "
				+ "\n0.Salir \n\nEscoja una opción:" );
		
	}
	private static void menuCuenta() {
		System.out.print("BANCO \n1.Cuenta Comun \n2.Cuenta Premium"
				+ "\n0.Salir \nEscoja una opción:" );
		
	}
	

}				
