package com.liceo.daw.ais;

import java.util.Arrays;

public class Recinto {

    private final Entrada[] entradas;
    private int entradasVendidas=0;
    private final int[] entradasFila ;
    private int entradasPistaDisponibles;
    private int entradasback;
    private int entradasGradaDisponibles;

    public Recinto(int numeroEntradas, int numeroDeFilas, int entradasPistaDisponibles, int entradasback, int entradasGradaDisponibles) {
        this.entradas = new Entrada[numeroEntradas];
        this.entradasFila = new int[numeroDeFilas];
        this.entradasPistaDisponibles = entradasPistaDisponibles;
        this.entradasback = entradasback;
        this.entradasGradaDisponibles = entradasGradaDisponibles;
    }

    public Entrada[] getEntradas() {
        return entradas;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }



    public void registrarEntrada(Entrada entrada){
        if (validarDisponibilidad(entrada)){
            entradas[entradasVendidas] = entrada;
            entradasVendidas++;
            if (entrada instanceof EntradaPista){
                entradasPistaDisponibles--;
                if (((EntradaPista) entrada).getBackstage()){
                    this.entradasback--;
                }
            }
            else {
                this.entradasGradaDisponibles--;
                entradasFila[((EntradaGrada)entrada).getFila()-1]++;
            }
        }
        else {
            System.out.println("Esta entrada no está disponible");
        }

    }

    public boolean validarAsistente(Asistente asistente){
        for (int i = 0; i < entradasVendidas; i++) {
            if (asistente.getMail().equals(entradas[i].getAsistente().getMail())){
                return false;
            }
        }
        return asistente.validateEdad();
    }

    public boolean validarDisponibilidad(Entrada entrada){
        if (entrada instanceof EntradaPista ){
            if (entradasPistaDisponibles <= 0){
                return false;
            }
            if(((EntradaPista) entrada).getBackstage()  && entradasback <= 0){
                return false;
            }
        }
        else{
            if (entradasGradaDisponibles <= 0){
                return false;
            }
            if(entradasFila[((EntradaGrada)entrada).getFila()] == 25){
                return false;
            }
            for (int i = 0; i < entradasVendidas; i++) {
                if (((EntradaGrada) entrada).getFila() == ((EntradaGrada)entradas[i]).getFila()
                    && ((EntradaGrada) entrada).getAsiento() == ((EntradaGrada)entradas[i]).getAsiento() ){
                    return false;
                }
            }

        }
        return true;
    }


    public void listarEntradas(){
        for (int i = 0; i < this.entradasVendidas; i++) {
            System.out.println(entradas[i].toString());
        }
    }

    @Override
    public String toString() {
        return "Recinto{" +

                ", entradas=" + Arrays.toString(entradas) +
                ", entradasVendidas=" + entradasVendidas +
                ", entradasFila=" + Arrays.toString(entradasFila) +
                ", entradasPistaDisponibles=" + entradasPistaDisponibles +
                ", entradasback=" + entradasback +
                ", entradasGradaDisponibles=" + entradasGradaDisponibles +
                '}';
    }
}
