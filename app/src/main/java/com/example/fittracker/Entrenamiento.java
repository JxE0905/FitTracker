package com.example.fittracker;

public class Entrenamiento {

    private String tipo;
    private String intensidad;
    private String aspectos;
    private int progreso;
    private float esfuerzo;

    public Entrenamiento(String tipo, String intensidad, String aspectos,
                         int progreso, float esfuerzo) {
        this.tipo = tipo;
        this.intensidad = intensidad;
        this.aspectos = aspectos;
        this.progreso = progreso;
        this.esfuerzo = esfuerzo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public String getAspectos() {
        return aspectos;
    }

    public int getProgreso() {
        return progreso;
    }

    public float getEsfuerzo() {
        return esfuerzo;
    }
}