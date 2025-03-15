package com.liceolapaz.daw.ais;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;

public class Principal 
{
	static final int MAX=5;
	static int posicionPelicula=0;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		
		Peliculas[] peliculas =new Peliculas[MAX];
		 do {
			mostrarMenu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:// insertar peli
				
				insetarPelicula(peliculas);
				break;
			case 2:// eliminar pelicula
				elimianrPeli(peliculas);
				
				break;//buscar
			case 3:
				buscarActores(peliculas);
				break;
			case 4:
	
				break;
			case 5://mostrar
				mostrarPeliculas(peliculas);
				break;
			case 0:
				
				break;

			default:
				break;
			}
			 
			 
			 
		} while (true);
		

	}
	private static void buscarActores(Peliculas[] peliculas) {
		System.out.println("Introduce el nombre del actor a buscar");
		String actor = sc.next();
		for (int i = 0; i < posicionPelicula; i++) 
		{
			for (int j = 0; j < peliculas[i].getActores().length; j++) 
			{
				if (peliculas[i].getActores()[j].equalsIgnoreCase(actor))
				{
					System.out.println("indice: "+i);
					peliculas[i].mostrar();
				}
			}
		}
		
	}
	private static void elimianrPeli(Peliculas[] peliculas) {
		System.out.println("Introduce la posicion de la pelicula a eliminar");
		int indice = sc.nextInt();
		try {
			peliculas[indice]=null;
			for (int i = indice; i < posicionPelicula; i++) 
			{
				peliculas[i]=peliculas[i+1];
			}
			peliculas[posicionPelicula]=null;
			posicionPelicula--;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	private static void mostrarPeliculas(Peliculas[] peliculas) {
		for (int i = 0; i < posicionPelicula; i++) 
		{
			System.out.println("indice: " + i +
					"\ntitulo: " + peliculas[i].getTitulo() +
					"\nactores: " + Arrays.asList(peliculas[i].getActores()) +
					"\nfecha: " + peliculas[i].getSaliDate() +"\n");
		}
		
	}
	private static void insetarPelicula(Peliculas[] peliculas) 
	{
		
		
		
		System.out.println("Introduce el titulo ");
		String titulo = sc.next(); 
		System.out.println("Introduce los actores separados por comas ");
		String[] actoreStrings =sc.next().split(",");
		System.out.println("introduce la fecha a-m-d");
		LocalDate fechaDate = LocalDate.parse(sc.next());
		
		
		peliculas[posicionPelicula]= new Peliculas(titulo, actoreStrings, fechaDate);
		posicionPelicula++;
		
	}
	private static void mostrarMenu() 
	{
		System.out.println("""
				1:ingresar pelicula
				2:eliminar pelicula
				3:buscar pelicula por actores
				4:modificar pelicula
				5:mostrar peliculas
				0:salir
				""");

		
	}

}
