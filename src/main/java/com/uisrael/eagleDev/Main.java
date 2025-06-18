package com.uisrael.eagleDev;

import com.uisrael.eagleDev.core.GestorConsumo;
import com.uisrael.eagleDev.core.RegistroConsumo;

import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestorConsumo gestor = new GestorConsumo();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== EcoConsumo ===");
            System.out.println("1. Agregar dispositivo");
            System.out.println("2. Eliminar dispositivo");
            System.out.println("3. Ver dispositivos");
            System.out.println("4. Ver fuentes disponibles");
            System.out.println("5. Simular consumo");
            System.out.println("6. Ver historial");
            System.out.println("7. Ver acciones");
            System.out.println("8. Deshacer última acción");
            System.out.println("9. Salir");
            System.out.print("Opción: ");

            int op = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (op) {
                case 1: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Consumo (kWh): ");
                    double consumo = sc.nextDouble();
                    sc.nextLine(); // Consumir el salto de línea
                    gestor.agregarElectrodomestico(nombre, consumo);
                    break;
                }
                case 2: {
                    System.out.print("Nombre: ");
                    gestor.eliminarElectrodomestico(sc.nextLine());
                    break;
                }
                case 3: {
                    List<?> dispositivos = gestor.getDispositivos(); // Usamos List<?> si el tipo exacto no se conoce
                    for (int i = 0; i < dispositivos.size(); i++) {
                        System.out.println(dispositivos.get(i));
                    }
                    break;
                }
                case 4: {
                    List<?> fuentes = gestor.getFuentesDisponibles();
                    for (int i = 0; i < fuentes.size(); i++) {
                        System.out.println(fuentes.get(i));
                    }
                    break;
                }
                case 5: {
                    System.out.print("Fuente: ");
                    String fuente = sc.nextLine();
                    System.out.print("Horas: ");
                    double horas = sc.nextDouble();
                    sc.nextLine(); // Consumir el salto de línea
                    gestor.simularConsumo(fuente, horas);
                    break;
                }
                case 6: {
                    // Asumiendo que getHistorial() devuelve una List<RegistroConsumo>
                    List<RegistroConsumo> historial = gestor.getHistorial();
                    for (int i = 0; i < historial.size(); i++) {
                        System.out.println(historial.get(i).getResumen());
                    }
                    break;
                }
                case 7: {
                    List<?> acciones = gestor.getAcciones();
                    for (int i = 0; i < acciones.size(); i++) {
                        System.out.println(acciones.get(i));
                    }
                    break;
                }
                case 8: {
                    gestor.deshacer();
                    break;
                }
                case 9: {
                    System.out.println("Gracias por usar EcoConsumo.");
                    sc.close(); // Cerrar el scanner
                    return;
                }
                default: {
                    System.out.println("Opción inválida.");
                    break;
                }
            }
        }
    }
}