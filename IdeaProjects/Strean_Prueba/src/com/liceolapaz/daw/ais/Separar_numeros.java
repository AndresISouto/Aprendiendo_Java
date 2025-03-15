package com.liceolapaz.daw.ais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Separar_numeros
{
    public static void main(String[] args)
    {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        for(int i = 0; i<40 ; i++)
        {
            lista.add(random.nextInt(-10,10));
        }

       lista.stream()
                .filter(n -> n>0)
                .distinct()
                .forEach(System.out ::println);



        long numerosNegativos = lista.stream()
                .filter(n -> n<0)
                .distinct()
                .count();
        System.out.println("Numeros negativos: "+numerosNegativos);

        long ceros = lista.stream()
                .filter(n-> n==0)
                .count();
        System.out.println("ceros: "+ceros);
    }

}
