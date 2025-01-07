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

        for (int i = 0; i < right; i++)
        {
           if (lista[i] > pivote)
           {
               swap();
               left++;
           }
        }
    }
}
