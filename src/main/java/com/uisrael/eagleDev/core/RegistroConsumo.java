package com.uisrael.eagleDev.core;

import com.uisrael.eagleDev.model.IFuenteEnergia;

public class RegistroConsumo {
    private final IFuenteEnergia fuente;
    private final double kWh;

    public RegistroConsumo(IFuenteEnergia fuente, double kWh) {
        this.fuente = fuente;
        this.kWh = kWh;
    }

    public double getCosto() {
        return fuente.calcularCosto(kWh);
    }

    public double getEmisiones() {
        return fuente.calcularEmisiones(kWh);
    }

    public String getResumen() {
        return String.format("%s: %.2f kWh → $%.2f | %.2f kgCO₂",
                fuente.getNombre(), kWh, getCosto(), getEmisiones());
    }

}