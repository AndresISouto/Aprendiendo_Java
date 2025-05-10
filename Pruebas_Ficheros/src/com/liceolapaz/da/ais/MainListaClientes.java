package com.liceolapaz.da.ais;

public class MainListaClientes {

	public static void main(String[] args) 
	{
		
		ListaClientes lista = new ListaClientes();
		
		lista.cargarClientes();
		do 
		{
			lista.operaciones();
			
		} while (true);

	}

}
