package com.uisrael.eagleDev.model;

public interface IFuenteEnergia {

    double calcularCosto(double kWh);
    double calcularEmisiones(double kWh);
    String getNombre();

}
