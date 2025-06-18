package com.uisrael.eagleDev.model;

public class Electrodomestico {

    private final String nombre;
    private final double consumoPorHora;

    public Electrodomestico(String nombre, double consumoPorHora) {
        this.nombre = nombre;
        this.consumoPorHora = consumoPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public double getConsumoPorHora() {
        return consumoPorHora;
    }

    @Override
    public String toString() {
        return nombre + " (" + consumoPorHora + " kWh/h)";
    }
}
