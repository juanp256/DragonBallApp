package com.example.dragonballapp;

public class Personaje {

    String nombre;
    String imagen;
    String especie;
    String ocupacion;
    String descripcion;
    String maxKi;
    String afiliacion;

    public Personaje(String nombre, String imagen, String especie, String ocupacion,
                     String descripcion, String maxKi, String afiliacion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.especie = especie;
        this.ocupacion = ocupacion;
        this.descripcion = descripcion;
        this.maxKi = maxKi;
        this.afiliacion = afiliacion;
    }

    public String getNombre() { return nombre; }
    public String getImagen() { return imagen; }
    public String getEspecie() { return especie; }
    public String getOcupacion() { return ocupacion; }
    public String getDescripcion() { return descripcion; }
    public String getMaxKi() { return maxKi; }
    public String getAfiliacion() { return afiliacion; }
}