package com.uisrael.eagleDev.core;

import com.uisrael.eagleDev.model.Electrodomestico;
import com.uisrael.eagleDev.model.IFuenteEnergia;
import com.uisrael.eagleDev.model.PanelSolar;
import com.uisrael.eagleDev.model.RedElectrica;

import java.util.*;

public class GestorConsumo {

    private final List<Electrodomestico> dispositivos = new ArrayList<>();
    private final Queue<RegistroConsumo> historial = new LinkedList<>();
    private final Stack<String> acciones = new Stack<>();
    private final Map<String, IFuenteEnergia> fuentes = new TreeMap<>();

    public GestorConsumo() {
        // Los nombres de las fuentes ahora se manejan en sus propias clases al extender FuenteEnergiaBase
        fuentes.put("Solar", new PanelSolar());
        fuentes.put("Red", new RedElectrica());
    }

    public void agregarElectrodomestico(String nombre, double consumo) {
        dispositivos.add(new Electrodomestico(nombre, consumo));
        acciones.push("Agregado: " + nombre);
        System.out.println("Electrodoméstico '" + nombre + "' agregado."); // ***MEJORA: Feedback al usuario***
    }

    public void eliminarElectrodomestico(String nombre) {
        boolean eliminado = dispositivos.removeIf(d -> d.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            acciones.push("Eliminado: " + nombre);
            System.out.println("Electrodoméstico '" + nombre + "' eliminado."); // ***MEJORA: Feedback al usuario***
        } else {
            System.out.println("Electrodoméstico '" + nombre + "' no encontrado."); // ***MEJORA: Feedback al usuario***
        }
    }

    public void simularConsumo(String fuenteNombre, double horas) {
        IFuenteEnergia fuente = fuentes.get(fuenteNombre);
        if (fuente == null) {
            System.out.println("Fuente de energía no encontrada: " + fuenteNombre); // ***CORRECCIÓN/MEJORA: Feedback al usuario***
            return;
        }

        if (dispositivos.isEmpty()) {
            System.out.println("No hay electrodomésticos para simular. Agregue algunos primero."); // ***MEJORA: Feedback al usuario***
            return;
        }

        System.out.println("\nSimulando consumo con " + fuente.getNombre() + " por " + horas + " horas:"); // ***MEJORA: Feedback al usuario***
        for (Electrodomestico d : dispositivos) {
            double kWh = d.getConsumoPorHora() * horas;
            RegistroConsumo registro = new RegistroConsumo(fuente, kWh);
            historial.add(registro);
            System.out.println("  " + d.getNombre() + ": " + registro.getResumen()); // ***MEJORA: Mostrar resultados de simulación inmediatamente***
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
}