package com.liceolapaz.da.ais;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.naming.InterruptedNamingException;

public class ListaClientes implements Serializable
{
	private Clientes[] clientes;
	
	static final String nombreFichero = "Data.dat";
	
	
	public void cargarClientes()//hay que cargar los datos antes de hacer nada
	{
		ObjectInputStream input = null;
		
	clientes = new Clientes[0];
		
		try 
		{
			input = new ObjectInputStream(new FileInputStream(nombreFichero));
			
			
			
			clientes = (Clientes[]) input.readObject();
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("No se ha encontrado fichero");
		}
		finally 
		{
			
			try 
			{
				if (input != null) {input.close();}
				
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
			}
		}
	}
	
	public void guardarCambios()
	{
		ObjectOutputStream output = null;
		
		try 
		{
			output = new ObjectOutputStream(new FileOutputStream(nombreFichero));
			
			output.writeObject(clientes);
			
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally 
		{
			try 
			{
				if(output != null) {output.close();}
			} 
			catch (Exception e2)
{
				// TODO: handle exception
			}
		}
	}
	
	public int menu()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("""
				1. Añadir Cliente
				2. Modificar datos
				3. Dar de baja
				4. Lista de clientes
				""");
		
		return sc.nextInt();
	}
	public void operaciones()
	{
		int opcion = menu();
		
		switch (opcion) 
		{
		case 1://Añadir clientes
			agregarClientes();
			break;
		case 2 ://Modificar datos
			modificarDatosCliente();
			
			break;
		case 3 ://Eliminar cliente
			eliminarDatosCliente();
			
		case 4 :
			for (int i = 0; i < clientes.length; i++) {
				clientes[i].info();
				
			}
			break;
			
			
		case 0 ://salir
			guardarCambios();
			
			System.out.println("Gracias por usar este programa ");
			System.exit(0);
			break;

		default:
			System.out.println();
			break;
		}
	}
	
	private void eliminarDatosCliente() 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el id del cliente a modificar");
		int id = sc.nextInt();
		sc.nextLine();
		
		int posicion = posicionId(id);
		
		if (posicion == -1)
		{
			System.out.println("No existe tal cliente");
		}
		
		else
		{
			for (int i = posicion; i < clientes.length-1; i++) 
			{
				clientes[i] = clientes[i+1];
			}
			clientes = Arrays.copyOf(clientes, clientes.length-1);
		}
		
	}

	private void modificarDatosCliente() 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el id del cliente a modificar");
		int id = sc.nextInt();
		sc.nextLine();
		
		int posicion = posicionId(id);
		
		if (posicion == -1)
		{
			System.out.println("No existe tal cliente");
		}
		else
		{
			System.out.println("introduce el nuevo Nombre: ");
			String Nombre = sc.nextLine();
			System.out.println("introduce el nuevo id: ");
			 id = sc.nextInt();
			System.out.println("introduce el nuevo tlfn: ");
			int telefono = sc.nextInt();
			
			clientes[posicion] = new Clientes(id, telefono, Nombre);
		}
		
	}

	public void agregarClientes()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("introduce el Nombre: ");
		String Nombre = sc.nextLine();
		System.out.println("introduce el id: ");
		int id = sc.nextInt();
		System.out.println("introduce el tlfn: ");
		int telefono = sc.nextInt();
		
		if(posicionId(id) == -1)
		{
			clientes = Arrays.copyOf(clientes, clientes.length+1);
			clientes[clientes.length-1] = new Clientes(id, telefono, Nombre);
		}
		else
		{
			System.out.println("El cliente ya existe");
		}
		
	}
	
	public int posicionId(int id)
	{
		int posicion = -1;
		
		for (int i = 0; i < clientes.length; i++) 
		{
			if(id == clientes[i].getId()) {posicion = i;}
			
		}
		return posicion;
	}
}

