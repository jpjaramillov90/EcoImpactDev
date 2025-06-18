package com.uisrael.eagleDev;

import com.uisrael.eagleDev.core.GestorConsumo;

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
            System.out.println("Opción: ");

            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Consumo (kWh): ");
                    double consumo = sc.nextDouble(); sc.nextLine();
                    gestor.agregarElectrodomestico(nombre, consumo);
                }
                case 2 -> {
                    System.out.println("Nombre: ");
                    gestor.eliminarElectrodomestico(sc.nextLine());
                }
                case 3 -> gestor.getDispositivos().forEach(System.out::println);
                case 4 -> gestor.getFuentesDisponibles().forEach(System.out::println);
                case 5 -> {
                    System.out.println("Fuente: ");
                    String fuente = sc.nextLine();
                    System.out.println("Horas: ");
                    double horas = sc.nextDouble(); sc.nextLine();
                    gestor.simularConsumo(fuente, horas);
                }
                case 6 -> gestor.getHistorial().forEach(r -> System.out.println(r.getResumen()));
                case 7 -> gestor.getAcciones().forEach(System.out::println);
                case 8 -> gestor.deshacer();
                case 9 -> {
                    System.out.println("Gracias por usar EcoConsumo.");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }

    }
}