package com.liceolapaz.daw.ais;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] lista = new int[0];

        do
        {
            try
            {
                System.out.println("introduce un numero positivo ");

                lista= Arrays.copyOf(lista,lista.length+1);

                lista[lista.length-1]=new Scanner(System.in).nextInt();

                //lista.add(new Scanner(System.in).nextInt());

                if (lista[lista.length-1] < 0)
                {
                    lista = Arrays.copyOf(lista,lista.length-1);
                    System.out.println("El numero tiene que ser positivo");
                }

            }
            catch (Exception e)
            {
                lista = Arrays.copyOf(lista,lista.length-1);

                System.out.println(e.getMessage());
            }
            
        } while (lista.length < 10);
        
      

        quicksort(lista, 0, lista.length-1);
        
        for (int i = 0; i < lista.length; i++) 
        {
			System.out.print(lista[i]+" ");
		}
    }

    static void swap(int[] lista,int left,int right)
    {
        int aux = lista[left];
        lista[left]=lista[right];
        lista[right]=aux;

    }

    static int permutar(int[] lista, int left, int right)
    {
        int pivote = lista[right];

        for (int i = left; i < right; i++)
        {
           if (lista[i] > pivote)
           {
               swap(lista, left, i);
               left++;
           }
        }
        
        swap(lista, left, right);
        
        return left;
    }
    
    static void quicksort(int[]lista,int left,int right)
    {
    	if (left < right) 
    	{
			int pivote = permutar(lista, left, right);
			
			quicksort(lista, left, pivote-1);	
			quicksort(lista, pivote+1, right);
					
		}
    }
}