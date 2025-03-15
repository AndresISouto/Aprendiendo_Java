package com.liceolapaz.daw.ais;

public abstract class Instrumentos 
{
	public enum Notas {DO,RE,MI,FA,SOL,LA,SI};
	
	private Notas[] notas;
	private int numNotas;
	
	static private int maxNotas=100;
	
	public Instrumentos()
	{
		notas = new Notas[maxNotas];
		numNotas=0;
	}
	
	public int getNumNotas()
	{
		return numNotas;
	}
	
	public Notas[] getNotas()
	{
		return notas;
	}
	
	public void agregarNota(Notas n)
	{
		if (numNotas < notas.length)
		{
			notas[numNotas] = n;
			numNotas++;
		}
	}
	
	public abstract void interpretacion();
}
