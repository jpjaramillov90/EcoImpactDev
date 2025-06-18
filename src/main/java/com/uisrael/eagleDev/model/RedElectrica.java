package com.uisrael.eagleDev.model;

public class RedElectrica implements IFuenteEnergia {

    public RedElectrica() {
    }

    public double calcularCosto(double kWh) {
        return kWh * 0.18;
    }

    public double calcularEmisiones(double kWh) {
        return kWh * 0.4;
    }

    @Override
    public String getNombre() {
        return "";
    }

}
