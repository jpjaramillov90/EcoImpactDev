package com.uisrael.eagleDev.core;

import java.util.*;

import com.uisrael.eagleDev.model.Electrodomestico;
import com.uisrael.eagleDev.model.IFuenteEnergia;
import com.uisrael.eagleDev.model.PanelSolar;
import com.uisrael.eagleDev.model.RedElectrica;

/**
 * Lógica de negocio del sistema EcoConsumo.
 */
public class GestorConsumo {
    private final List<Electrodomestico> dispositivos = new ArrayList<>();
    private final Queue<RegistroConsumo> historial = new LinkedList<>();
    private final Stack<String> acciones = new Stack<>();
    private final Map<String, IFuenteEnergia> fuentes = new TreeMap<>();

    public GestorConsumo() {
        fuentes.put("Solar", new PanelSolar());
        fuentes.put("Red", new RedElectrica());
    }

    public void agregarElectrodomestico(String nombre, double consumo) {
        dispositivos.add(new Electrodomestico(nombre, consumo));
        acciones.push("Agregado: " + nombre);
    }

    public void eliminarElectrodomestico(String nombre) {
        boolean eliminado = dispositivos.removeIf(d -> d.getNombre().equalsIgnoreCase(nombre));
        if (eliminado)
            acciones.push("Eliminado: " + nombre);
    }

    public void simularConsumo(String fuenteNombre, double horas) {
        IFuenteEnergia fuente = fuentes.get(fuenteNombre);
        if (fuente == null)
            return;

        for (Electrodomestico d : dispositivos) {
            double kWh = d.getConsumoPorHora() * horas;
            historial.add(new RegistroConsumo(fuente, kWh));
        }
        acciones.push("Simulación: " + fuente.getNombre());
    }

    public List<Electrodomestico> getDispositivos() {
        return dispositivos;
    }

    public List<String> getFuentesDisponibles() {
        return new ArrayList<>(fuentes.keySet());
    }

    public List<RegistroConsumo> getHistorial() {
        return new ArrayList<>(historial);
    }

    public Stack<String> getAcciones() {
        return acciones;
    }

    public void deshacer() {
        if (!acciones.isEmpty())
            acciones.pop();
    }
}