package com.uisrael.eagleDev.model;

public class RedElectrica extends FuenteEnergiaBase {
    public RedElectrica() {
        super("Red Eléctrica");
    }

    public double calcularCosto(double kWh) {
        return kWh * 0.18;
    }

    public double calcularEmisiones(double kWh) {
        return kWh * 0.4;
    }
}
