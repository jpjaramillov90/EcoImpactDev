package com.uisrael.eagleDev.model;

public class RedElectrica extends FuenteEnergiaBase { // EXTENDS FuenteEnergiaBase

    public RedElectrica() {
        super("Red"); 
    }

    @Override
    public double calcularCosto(double kWh) {
        return kWh * 0.18;
    }

    @Override
    public double calcularEmisiones(double kWh) {
        return kWh * 0.4;
    }
}