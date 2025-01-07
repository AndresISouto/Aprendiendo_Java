package com.liceolapaz.daw.ais;

public class Kata {
    public static void main(String[] args) {
        System.out.println(century(1438));
    }
    public static int century(int number) {

        int digitos = (int) Math.log10(number)+1;
        if (digitos == 2) return 1;
        if (digitos == 3){
            // primer digito mas uno a no ser que acabe en 00
            if (number%100==0) return number/100;
            else return number/100+1;
        }
        if (digitos==4){
            if (number%100==0) return number/100;
            else return number/100+1;
        }
    return 0;

    }
}
