package com.liceolapaz.daw.ais;

import java.awt.image.BandCombineOp;
import java.security.PrivateKey;

public class CuentaCorriente 
{
	
	private double saldo;
	private double limite;
	private String titular;
	
	private Banca banca;
	
	
	
	public CuentaCorriente(String titular)	
	{
		this.saldo = 0;
		limite = -50;
		this.titular =titular;
		
	}
	public CuentaCorriente(String titular, double saldo, double limite)
	{
		this.saldo = saldo;
		this.limite = limite;
		this.titular =titular;
		
	}
	
	public void sacarDinero(double cantidad)
	{
		if (saldo - cantidad < limite) 
		{
			System.out.println("Operacion invalida, no tienes suficiente dinero");
		}
		else {
			saldo -= cantidad;
		}
	}
	
	public void ingresar(double cantidad)
	{
		saldo += cantidad;
	}
	
	public void mostrar()
	{
		System.out.println("Nombre del titular: "+ titular + "\nSaldo: "+saldo+"\nLimite: "+limite + "\banca: " + banca);
	}
	
	

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public void setBanca(Banca banca)
	{
		this.banca = banca;
	}
	
	
}
