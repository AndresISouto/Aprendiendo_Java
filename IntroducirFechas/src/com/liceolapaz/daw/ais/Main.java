package com.liceolapaz.daw.ais;

import java.util.Scanner;



public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
//		boolean fechaboolen=false,diaboolean=false,mesboolean= true,anhoboolean=true;
		
		int key =1;
		
		int dia=-1,mes=-1,anho=-1;
		
		int[] diasmes = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		while (key != 4) 
		{
			while(key == 1)
			{
//				mesboolean= true;
//				anhoboolean = true;
				
				System.out.println("Introduce un día");
				dia = sc.nextInt();
				
				if (dia > 0 && dia <= 31) 
				{
//					diaboolean = true;
//					mesboolean = false;
					key = 2;
				} 
				else 
				{
					System.out.println("Día no valido");
				}
				
			}
			
			if (key ==2) 
			{
				System.out.println("Introduce un mes del 1 al 12");
				mes = sc.nextInt();
				
				if (mes > 0 && mes <= 12) 
				{
					if (dia <= diasmes[mes-1] ) 
					{
//						mesboolean = true;
//						anhoboolean =false;
						key =3;
					}
					else
					{
						System.out.println("El número de dias es incompatible con el mes");
//						mesboolean = true;
//						diaboolean = false;
						key=1;
					}
				}
				else
				{
					System.out.println("mes no valido");
//					mesboolean = true;
//					diaboolean = false;
					key=1;
				}
				
			}
			
			if (key ==3) 
			{
				System.out.println("Introduce un Año");
				anho = sc.nextInt();
				
				if (anho != 0) 
				{
					if (mes==2 && dia==29) 
					{
						if (!(anho%4==0 && anho%400!=0)) 
						{
							System.out.println("Este año no es bisiesto");
//							anhoboolean=true;
//							mesboolean=true;
//							diaboolean=false;
							key=1;
						}
						else
						{
//							anhoboolean=true;
//							fechaboolen=true;
							key=4;
						}
					} 
					else 
					{
//						anhoboolean=true;
//						fechaboolen=true;
						key=4;
					}
				}
				else 
				{
					System.out.println("El año no puede ser 0");
//					anhoboolean=true;
//					mesboolean=true;
//					diaboolean= false;
					key=1;
				}
			}
		}
		
		System.out.println(dia+"/"+mes+"/"+anho);
		

	}

}
