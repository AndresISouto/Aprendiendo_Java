package com.liceo.daw.ais;

public class Usuario {
    private int id;
    private String mail;
    private String nombre;
    private String apellido;
    private String avatar;

    public Usuario(int id, String mail, String nombre, String apellido, String avatar) {
        this.id = id;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "  {\n" +
                "\t\"id\": " + id + ", \n" +
                "\t\"email\": \"" + mail + "\", \n" +
                "\t\"first_name\": \"" + nombre + "\", \n" +
                "\t\"last_name\": \"" + apellido + "\", \n" +
                "\t\"avatar\": \"" + avatar + "\" \n" +
                "  },";
    }
}
