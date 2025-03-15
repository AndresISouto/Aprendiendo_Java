package com.liceolapaz.daw.ais;

import java.util.Comparator;

public class CompararAlfabeticamente implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		
		return o1.getDni().compareTo(o2.getDni());
	}
	
}

