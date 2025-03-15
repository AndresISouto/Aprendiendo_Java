package com.liceolapaz.daw.ais;

public class campana extends Instrumentos
{
	public campana()
	{
		super();
	}
	@Override
	public void interpretacion() {
		for (int i = 0; i < getNumNotas(); i++) 
		{
			switch (getNotas()[i]) {
			case DO:
				System.out.println("Dolooooon");
				break;

			default:
				break;
			}
		}
		
	}
	

}
