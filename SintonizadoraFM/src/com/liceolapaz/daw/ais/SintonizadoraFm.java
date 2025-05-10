package com.liceolapaz.daw.ais;

public class SintonizadoraFm 
{
	private int frecuencia; //MHZ
	
	public SintonizadoraFm(int frecuencia)
	{
		this.frecuencia = frecuencia;
	}
	
	public void up(int n)
	{
		frecuencia += 0.5*n;
		while (frecuencia > 108) 
		{
			frecuencia -= 28;
		}
	}
	public void down(int n)
	{
		frecuencia -= 0.5*n;
		while (frecuencia < 80) 
		{
			frecuencia += 28;
		}
	}
}

