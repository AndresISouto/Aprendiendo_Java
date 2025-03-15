package com.liceolapaz.daw.ais;



import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Marco extends JFrame
{
	
	private static final long serialVersionUID = 2144333782928270968L;

	public Marco()
	{
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimension = pantalla.getScreenSize();
		
		setSize(dimension.width/2,dimension.height/2);
		
		
		
		//setSize(500, 300);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setLocation(450,200);
		setLocation(dimension.width/4,dimension.height/4);
		
		setTitle("hola mundo");
	}
}
