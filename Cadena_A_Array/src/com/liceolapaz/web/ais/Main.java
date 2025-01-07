package com.liceolapaz.web.ais;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	 /*Introduciremos una cadena y la pasaremos
    a un array y luego leeremos  el array al reves

    trataremos de unar solo una variable*/

        /*Solo podemos guardar una variable que va a tener que ser el array
         porque tenemos que comprobar si son positivos y luego printearlos al reves
         */


        public static void main(String[] args)
        {
            int[] lista = new int[0];

            do
            {
                try
                {
                    System.out.println("introduce un numero positivo ");

                    lista=Arrays.copyOf(lista,lista.length+1);

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

            while (lista.length > 0)
            {
                System.out.println(lista[lista.length-1]);
                lista = Arrays.copyOf(lista,lista.length-1);
            }



        }

}


