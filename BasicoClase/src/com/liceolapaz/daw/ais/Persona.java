package com.liceolapaz.daw.ais;


import java.time.*;
import java.util.Comparator;



public class Persona 
{
//	public Persona(String nombre, String apellido, String dni, String sexo, int peso, int altura,
//			LocalDate fechadeNacimiento) {
//		super();
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.dni = dni;
//		this.sexo = sexo;
//		this.peso = peso;
//		this.altura = altura;
//		this.fechadeNacimiento = fechadeNacimiento;
//	}

	public Persona() {
		super();
	}

	private String nombre;
	private String apellido;
	private String dni;
	private String sexo;
	private int peso;
	private int altura;
	private LocalDate fechadeNacimiento;
	
	public Persona(String nombre, String apellido, String dni, String sexo ,int peso,int altura,int anho, int mes, int dia)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
		this.fechadeNacimiento = LocalDate.of(anho, mes, dia);
		
	}
	
	public void desplegable() {
		System.out.println("Nombre: "+nombre+"\napellido: "+apellido+"\ndni: "+dni+"\nsexo "+sexo+"\npeso "+peso+"\naltura: "+altura
				+"\nfecha: "+fechadeNacimiento);
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public LocalDate getFechadeNacimiento() {
		return fechadeNacimiento;
	}

	public void setFechadeNacimiento(LocalDate fechadeNacimiento) {
		this.fechadeNacimiento = fechadeNacimiento;
	}
	
	
	
}
