package com.liceolapaz.da.ais;

import java.io.Serializable;

public class Clientes implements Serializable
{
	public Clientes(int id, int telefono, String nombre) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
	}
	private int id;
	private int telefono;
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void info()
	{
		System.out.println("\nNombre: "+nombre+"\ntlfn: "+telefono+"\nid: "+id);
	}
	
}
