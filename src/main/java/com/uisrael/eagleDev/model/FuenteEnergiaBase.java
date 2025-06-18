package com.uisrael.eagleDev.model;

public abstract class FuenteEnergiaBase implements IFuenteEnergia {

    protected final String nombre;

    public FuenteEnergiaBase(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
