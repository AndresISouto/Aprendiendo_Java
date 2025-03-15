package com.liceolapaz.daw.ais;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaCoches 
{
	public ListaCoches(Coche[] coche) {
		super();
		this.coche = coche;
	}

	private Coche[] coche;

	public Coche[] getCoches() {
		return coche;
	}

	public void setCoches(Coche[] coche) {
		this.coche = coche;
	}
	public void mostrar()
	{
		System.out.println(Arrays.asList(coche));
	}
	public Coche cochePosicion(int posicion)
	{
		return coche[posicion];
	}
	public int posicionMatricula(int matricula)
	{
		for (int i = 0; i < coche.length; i++) 
		{
			if (coche[i].getMatricula() == matricula) {
				return i;
			}
		}
		return -1;
	}
	public ArrayList<Coche> cochesMarca(String marca)
	{
		ArrayList<Coche> aux = new ArrayList<>();
		for (int i = 0; i < coche.length; i++) 
		{
			if (coche[i].getMarca().equalsIgnoreCase(marca) ) {
				aux.add(coche[i]);
			}
		}
		return aux;
	}
}
