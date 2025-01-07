package com.liceolapaz.daw.ais;

public class Coche {
public Coche(String marca, int matricula) {
		super();
		this.marca = marca;
		this.matricula = matricula;
	}

/*modelo matricula marca color
 * constructores y destructor
 * setters y getters
 * metodo de muestra
 * crear clase ListaCoches que contenga un array de clase coches
 * A[pos] devuelva el coche que se encuentra en esa posicion
 * A[matricula] devuelve la posicion del coche cuya matriculacoincide con la llamada, en el claso de no haberla devolver -1
 * A[marca] devuelve la lista de coche de x marca*/
	
	private String marca;
	
	private int matricula; // asumimos matricula de numeros por ponerle variedad

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public void mostrar()
	{
		System.out.println("\nmarca: "+marca+
				"\nmatricula"+matricula);
	}

	
	
}
