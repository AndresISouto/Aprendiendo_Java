package com.liceolapaz.daw.ais;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BasicoClase {
	
	static int posicion=0;
	static final int MAX=20;
	

	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		
		Persona[] persona = new Persona[MAX];
		
		int opcion;
		
		do 
		{
			System.out.println("""
					1:Insertar persona
					2:Remover persona
					3:modificar persona
					4:ordenar por altura
					5:mostrar todos
					6: buscar por nombre
					0:salir
					""");
			 opcion =scanner.nextInt();
			
			switch (opcion) {
			case 1:// añadir personaje
				
				 System.out.println("introduce nombre");
				 String nombre=scanner.next();
				 
				 System.out.println("introduce apellido");
				 String apellido=scanner.next();
				 
				 System.out.println("introduce dni");
				 String dni=scanner.next();
				 System.out.println("introduce sexo");
				 String sexo=scanner.next();
				 System.out.println("introduce peso (Kg)");
				 int peso=scanner.nextInt();
				 System.out.println("introduce altura (cm)");
				 int altura=scanner.nextInt();
				 System.out.println("introduce año"); 
				 int anhoInteger=scanner.nextInt();
				 System.out.println("introduce mes");
				 int mesInteger=scanner.nextInt();
				 System.out.println("introduce dia");
				 int diaInteger=scanner.nextInt();
				 LocalDate fechaEspecifica = LocalDate.of(anhoInteger, mesInteger, diaInteger);
				
				 persona[posicion] = new Persona(nombre, apellido, dni, sexo, peso, altura, anhoInteger, mesInteger, diaInteger);
				posicion++;		
				break;
			case 2://remover personaje
				System.out.println("elegir la posicion del personaje a remover");
				int remover = scanner.nextInt();
				persona[remover]=null;
				for (int i = remover; i < persona.length-1; i++) {
					persona[i]=persona[i+1];
				}
				persona[MAX-1]=null;
				posicion--;
				break;
			case 3://modificar personaje
				menuModificacion(persona);
	
				break;
				
			case 4:// ordenar por altura
				//ComparadorEdad comparadorEdad = new ComparadorEdad();
				//Arrays.sort(persona, Comparator<persona>);
				// Ordenar por edad
		        Arrays.sort(persona, new Comparator<Persona>() {
		            
		            public int compare(Persona p1, Persona p2) {
		                return Integer.compare(p1.getAltura(), p2.getAltura());
		            }
		        });
				
				break;
			case 5: //mostrar
				if(posicion==0) {System.out.println("No hay elementos");}
				for (int i=0; i<posicion;i++ ) {
					persona[i].desplegable();
					
				}
				break;			
			case 0:
					System.out.println("vuelva protnto");
					System.exit(0);
				break;
			case 6:
				buscarPorNombre(persona);
				break;

			default:
				break;
			}
			
		} while (true);
		
		
		
}

	private static void buscarPorNombre(Persona[] persona) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Escribe el nombre de la persona a buscar");
		String nombre = scanner.next();
		for (int i = 0; i < posicion; i++) {
			if (persona[i].getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("indice: "+i);
				persona[i].desplegable();
			}
			
		}
		
		
	}

	private static void menuModificacion(Persona[] persona) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Elije el numero de personaje a modificar por numero");
		int posicion = scanner.nextInt();
		System.out.println("""
				1: modificar nombre
				2: modificar peso
				3 modificar altura
				""");
		int opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			System.out.println("introduce el nuevo nombre");
			
			persona[posicion].setNombre(scanner.nextLine());
			break;
		case 2:
			System.out.println("introduce el nuevo peso");
			
			persona[posicion].setPeso(scanner.nextInt());
			break;
		case 3:
			System.out.println("introduce la nueva altura");
			
			persona[posicion].setAltura(scanner.nextInt());
	
			break;
			

		default:
			break;
		}
		
	}
}
