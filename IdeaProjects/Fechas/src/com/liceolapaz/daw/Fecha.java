package com.liceolapaz.daw;

import java.time.LocalDate;

public class Fecha 
{
	public Fecha(LocalDate fechaDate) {
		
		this.fecha = fechaDate;
	}
	

	private LocalDate fecha;
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void DiaSemana()
	{
		System.out.println(this.fecha.getDayOfWeek());
	}
	static public Fecha DiaSiguiente(Fecha fecha)
	{
		
		return new Fecha(fecha.getFecha().plusDays(1));
	}
	public void mostrarFecha()
	{
		System.out.println(fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear());
	}
	public boolean mayor (Fecha f2)
	{
		if (this.fecha.compareTo(f2.getFecha()) < 0) {
			return false;
		}
		return true;
	}
	public boolean menor (Fecha f2)
	{
		if (this.fecha.compareTo(f2.getFecha()) > 0) {
			return false;
		}
		return true;
	}
	public boolean igual (Fecha f2)
	{
		if (this.fecha.compareTo(f2.getFecha()) == 0) {
			return true;
		}
		return false;
	}
}
