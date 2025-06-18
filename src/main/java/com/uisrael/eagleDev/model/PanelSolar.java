package com.uisrael.eagleDev.model;

public class PanelSolar extends FuenteEnergiaBase {
    public PanelSolar() {
        super("Panel Solar");
    }

    public double calcularCosto(double kWh) {
        return 0.0;
    }

    public double calcularEmisiones(double kWh) {
        return 0.0;
    }

}