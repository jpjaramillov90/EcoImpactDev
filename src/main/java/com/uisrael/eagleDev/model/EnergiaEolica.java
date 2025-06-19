package com.uisrael.eagleDev.model;

public class EnergiaEolica extends FuenteEnergiaBase{

    public EnergiaEolica(){
        super("Eolica");
    }

    @Override
    public double calcularCosto(double kWh){
        return kWh * 0.07;
    }

    @Override
    public double calcularEmisiones(double kWh){
        return kWh * 0.02;
    }

    
}
