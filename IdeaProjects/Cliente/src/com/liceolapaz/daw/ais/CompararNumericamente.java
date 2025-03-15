package com.liceolapaz.daw.ais;

import java.util.Comparator;

public class CompararNumericamente implements Comparator<Cliente>{

@Override
public int compare(Cliente o1, Cliente o2) {
	// TODO Auto-generated method stub
	return Integer.compare(o1.getEdad(), o2.getEdad());
}
}