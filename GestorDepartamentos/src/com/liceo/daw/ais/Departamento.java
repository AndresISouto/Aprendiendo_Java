package com.liceo.daw.ais;

import java.lang.annotation.Retention;

public class Departamento {

    //num_depto;nombre;nombre_corto;planta;cif_director;correo_e
    private int num_departamento;
    private String nombre;
    private String nombre_corto;
    private int planta;
    private String cif_director;
    private String correo;

    public Departamento(int num_departamento, String nombre, String nombre_corto, int planta, String cif_director, String correo) {
        this.num_departamento = num_departamento;
        this.nombre = nombre;
        this.nombre_corto = nombre_corto;
        this.planta = planta;
        this.cif_director = cif_director;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return num_departamento + ";" + nombre + ";" + nombre_corto + ";" + planta + ";" + cif_director + ";" + correo;
    }
}
