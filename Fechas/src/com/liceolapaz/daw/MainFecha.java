package com.liceolapaz.daw;

import java.security.spec.MGF1ParameterSpec;
import java.time.LocalDate;

public class MainFecha {

	public static void main(String[] args) {
		Fecha fecha = new Fecha(LocalDate.of(2000, 2, 29));
		
		Fecha fecha2 = Fecha.DiaSiguiente(fecha);
		

		
		
	}

}
