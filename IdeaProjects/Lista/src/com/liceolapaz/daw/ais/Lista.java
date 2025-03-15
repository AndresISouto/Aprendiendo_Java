package com.liceolapaz.daw.ais;

import java.util.Arrays;

public class Lista 
{
	private Integer[] integer;
	private int elementos;
	
	public Lista() {
		elementos=0;
		integer = new Integer[10];
	}
	
	public Lista(int numMax)
	{
		elementos = 0;
		integer = new Integer[numMax];
	}
	
	public int getElementos()
	{
		return elementos;
	}
	
	public int size()
	{
		return integer.length;
	}
	
	public boolean listaLlena()
	{
		return elementos == integer.length;
	}
	
	public void insertarAlFinall(Integer numero)
	{
		if (listaLlena() )
		{
			integer = Arrays.copyOf(integer,integer.length +1);	
		}
		integer[elementos] = numero;
		elementos++;
	}
	
	public void insertarAlPrincipio(Integer numero)
	{
		if (listaLlena() )
		{
			integer = Arrays.copyOf(integer,integer.length +1);	
		}
		for (int i = elementos; i > 0; i--) 
		{
			integer[elementos] = integer[elementos-1];
		}
		elementos++;
	}
	
	public void insertarEnPosicion(Integer numero, int posicion)
	{
		integer[posicion] = numero;
	}
	
	public void insertarListaAlFinall(Lista lista)
	{
		if (lista.integer.length > integer.length-elementos )
		{
			integer = Arrays.copyOf(integer, integer.length - elementos + lista.integer.length);	
		}
		for (int i = 0; i < integer.length - elementos; i++) 
		{
			integer[elementos+i] = lista.integer[i];
		}
		elementos += lista.integer.length;
	}
	
	public void eliminarElementos(int posicion)
	{
		for (int i = posicion; i < integer.length -1; i++) 
		{
			integer[i] = integer[i + 1];
		}
		elementos--;
		integer = Arrays.copyOf(integer, integer.length-1);
	}
	
	public Integer indice(int posicion)
	{
		return integer[posicion];
	}
	
	
}

