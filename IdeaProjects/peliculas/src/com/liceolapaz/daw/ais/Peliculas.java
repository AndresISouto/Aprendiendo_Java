package com.liceolapaz.daw.ais;

import java.time.LocalDate;
import java.util.Arrays;

public class Peliculas {
	
	/*Imagina que quieres crear un programa que te permita organizar los DVD 
	 * de pelis por casa.Crea una clase peliculas con titolo actores[] director[]
	 *  fecha de salida, formato
	 *  hacer un programa para insertar, buscar, eliminar, modificar un programa*/
	public Peliculas(String tituloString, String[] actores, LocalDate saliDate) {
		super();
		this.titulo = tituloString;
		this.actores = actores;
		this.saliDate = saliDate;
	}
	//public Peliculas() {}

	private String titulo;
	private String[]actores;
	private LocalDate saliDate;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String[] getActores() {
		return actores;
	}
	public void setActores(String[] actores) {
		this.actores = actores;
	}
	public LocalDate getSaliDate() {
		return saliDate;
	}
	public void setSaliDate(LocalDate saliDate) {
		this.saliDate = saliDate;
	}
	public void mostrar()
	{
		
			System.out.println(
					"\ntitulo: " + titulo +
					"\nactores: " + Arrays.asList(actores) +
					"\nfecha: " + saliDate +"\n");
		
	}

}
