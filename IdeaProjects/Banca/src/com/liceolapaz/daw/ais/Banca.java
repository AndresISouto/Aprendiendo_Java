package com.liceolapaz.daw.ais;

public class Banca 
{
	private String nombre;
	private double capital;
	private String dir;
	
	public Banca(String nombre)
	{
		this.nombre = nombre;
		capital = 5200000;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public double getCapital() {
		return capital;
	}

	public String getDir() {
		return dir;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	
}


