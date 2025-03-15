package com.liceolapaz.daw.ais;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int decimal ;
        String binario ;
        int opcion ;


        do
        {
            menu();

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: // de decimal a binario
                    System.out.println("Introduce un número decimal");
                    decimal = Integer.parseInt(sc.nextLine());
                    System.out.println("El numero binario correspondiente es: "+ decimalABinario(decimal)+"\n");

                    break;
                case 2://de binario a decimal
                    System.out.println("Introduce un número binario");
                    binario = sc.nextLine();
                    if(comprobarBinario(binario)){
                        System.out.println("El numero Decimal correspondiente es: "+ binarioADecimal(binario) +"\n");

                    }
                    else {
                        System.out.println("formato incorrecto\n");
                    }



                    break;
                case 0:
                    System.out.println("Gracias por usar este programa");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Introduce una opción válida");
                    break;
            }

        } while (true);

    }

    private static String decimalABinario(int decimal) {

        String binario ="";
        //String aux="";

        while (decimal!= 1 && decimal != 0)
        {
            binario = (decimal%2) + binario;
            decimal /= 2;

        }

        binario = decimal + binario;

       // for (int i = binario.length() ; i > 0; i--) //binario 11001 -> 10011
        //{
          //  aux = aux +  binario.charAt(i-1) ;
        //}

        return binario;
    }

    private static int binarioADecimal(String binario)
    {
        double decimal=0;

        for (int i = binario.length()-1,j=0; i >=0 ; i--,j++)
        {
            decimal += ((double)binario.charAt(i)-'0') * Math.pow(2,j);

        }//Character.getNumericValue(charAt(i))


        return (int)decimal;
    }

    private static void menu()
    {
        System.out.println("""
				Elija una opción
				
				1: De decimal a binario
				
				2: De binario a decimal
				
				0: Salir
				""");


    }
    private static boolean comprobarBinario(String binario){


        for (int i = 0; i < binario.length(); i++) {
            if (binario.charAt(i)!='1' && binario.charAt(i)!='0'){
                return false;
            }
        }
        return true;
    }

}
