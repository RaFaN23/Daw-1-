package org.example.practica;

public class Senuelo {
    private String referencia;
    private String modelo;
    private String tamanyo;
    private String color;
    private String navegabilidad;
    private String ojos;
    private double peso;
    private String disponibilidad;
    private double pvp;

    public Senuelo(String referencia, String modelo, String tamanyo, String color,
                   String navegabilidad, String ojos, double peso,
                   String disponibilidad, double pvp) {
        this.referencia = referencia;
        this.modelo = modelo;
        this.tamanyo = tamanyo;
        this.color = color;
        this.navegabilidad = navegabilidad;
        this.ojos = ojos;
        this.peso = peso;
        this.disponibilidad = disponibilidad;
        this.pvp = pvp;
    }

    // Getters (necesarios para PropertyValueFactory)
    public String getReferencia() { return referencia; }
    public String getModelo() { return modelo; }
    public String getTamanyo() { return tamanyo; }
    public String getColor() { return color; }
    public String getNavegabilidad() { return navegabilidad; }
    public String getOjos() { return ojos; }
    public double getPeso() { return peso; }
    public String getDisponibilidad() { return disponibilidad; }
    public double getPvp() { return pvp; }
}