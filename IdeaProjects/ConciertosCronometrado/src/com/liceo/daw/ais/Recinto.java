package com.liceo.daw.ais;

public class Recinto {
    private Entrada[] entradas = new Entrada[26000];

    private int entradasVendidas=0;
    private int entradasBack=100;
    private int entradasPista=900;
    private int  entradasGrada=25000;

    private boolean[][] gradasLibres = new boolean[25][1000];

    public Recinto() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 1000; j++) {
                gradasLibres[i][j] = true;
            }
        }
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }

    public void mostrarEntradas(){
        for (int i = 0; i < entradasVendidas; i++) {
            System.out.println(entradas[i].toString());
        }
    }
    public boolean validarEntrada(Entrada entrada){
        if (entradasVendidas == 26000){
            System.out.println("Ya no se pueden vender más entradas");
            return false;
        }
        if (entrada instanceof EntradaPista && ((EntradaPista) entrada).isBack() && entradasBack==0){
            System.out.println("ya no  quedan entradas de back");
            return false;
        }
        if (entrada instanceof EntradaPista && !((EntradaPista) entrada).isBack() && entradasPista==0){
            System.out.println("ya no  quedan entradas de pista");
            return false;
        }
        if (entrada instanceof  EntradaGrada && entradasGrada==0){
            System.out.println("ya no  quedan entradas de grada");
            return false;
        }
        if (entrada instanceof EntradaGrada && !gradasLibres[((EntradaGrada) entrada).getFila()-1][((EntradaGrada) entrada).getAsiento()-1]){
            System.out.println("ese asiento ya está ocupado");
            return false;
        }
        if(mailYaUsado(entrada.getAsistente().getMail())){
            System.out.println("ese mail ya está usado");
            return false;
        }
        if (!entrada.getAsistente().validarEdad()) {
            System.out.println("El asistente tiene que ser mayor de edad");
            return false;
        }
        else {return true;}
    }

    public void addEntrada(Entrada entrada){
        if (validarEntrada(entrada)){
            entradas[entradasVendidas] = entrada;
            entradasVendidas++;

            if (entrada instanceof EntradaPista){
                if (((EntradaPista) entrada).isBack()){
                    entradasBack--;
                }
                else {
                    entradasPista--;
                }
            }
            else {
                entradasGrada--;
                gradasLibres[((EntradaGrada) entrada).getFila()-1][((EntradaGrada) entrada).getAsiento()-1] = false;
            }
        }
    }

    public Entrada buscarEntrada(String mail){
        for (int i = 0; i < entradasVendidas ; i++) {
           if (entradas[i].getAsistente().getMail().equalsIgnoreCase(mail)){
               return entradas[i];
           }
        }
        System.out.println("No se encontró ninguna entrada");
        return null;
    }

    public boolean mailYaUsado(String mail){
        for (int i = 0; i < entradasVendidas ; i++) {
            if (entradas[i].getAsistente().getMail().equalsIgnoreCase(mail)){
                return true;
            }
        }
        return false;
    }

}
