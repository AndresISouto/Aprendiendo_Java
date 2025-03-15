package com.liceolapaz.daw.ais;

public class Cliente 
{
	public Cliente(String dni, int edad) {
		super();
		this.dni = dni;
		this.edad = edad;
	}
	private String dni;
	private int edad;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dniString) {
		this.dni = dniString;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String toString()
	{
		
		return "dni: " +dni+ "\nedad: "+edad;
	}
	
	public boolean equals(Object ob)
	{
		return this.dni.equals(((Cliente)ob).dni);
	}
	
	
	
}
