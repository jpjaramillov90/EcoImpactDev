package com.uisrael.eagleDev.model;

public class PanelSolar extends FuenteEnergiaBase {

    public PanelSolar() {
        super("Solar");
    }

    @Override
    public double calcularCosto(double kWh) {
        return 0.0;
    }

    @Override
    public double calcularEmisiones(double kWh) {
        return 0.0;
    }
}