package com.uisrael.eagleDev.model;

public class PanelSolar implements IFuenteEnergia {

    public PanelSolar() {
        super();
    }

    public double calcularCosto(double kWh) {
        return 0.0;
    }

    public double calcularEmisiones(double kWh) {
        return 0.0;
    }

    @Override
    public String getNombre() {
        return "";
    }

}
