package com.uisrael.eagleDev;

import com.uisrael.eagleDev.core.GestorConsumo;
import com.uisrael.eagleDev.core.RegistroConsumo;
import com.uisrael.eagleDev.core.Validaciones;
import com.uisrael.eagleDev.model.Electrodomestico; // ***MEJORA: Importar Electrodomestico para tipo específico***
import com.uisrael.eagleDev.resources.MenuDisplay;

import java.util.List;
import java.util.Scanner;
import java.util.Stack; // ***MEJORA: Importar Stack para tipo específico***

public class Main {
    public static void main(String[] args) {

        GestorConsumo gestor = new GestorConsumo();
        Scanner sc = new Scanner(System.in);
        MenuDisplay md = new MenuDisplay();

        md.seeHeaderv();
        while (true) {
            md.seeMenu();
            int op = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (op) {
                case 1: {
                    String nombre;
                    while (true) {
                        System.out.print("Nombre del electrodoméstico: "); // ***MEJORA: Clarificar el mensaje***
                        nombre = sc.nextLine();
                        if (Validaciones.ValidarNombre(nombre)){ //*MEJORA : Validaciones de entrada */
                            break;
                        }else{
                            System.out.println("El nombre solo debe contener letras.Intente nuevamente");
                        }
                    }
                    
                     double consumo;
                     while (true) {
                        System.out.print("Consumo por hora (kWh/h): "); // ***MEJORA: Clarificar el mensaje***
                        String input = sc.nextLine();
                        if (Validaciones.ValidarConsumo(input)) { //*MEJORA : Validaciones de entrada */
                            consumo = Double.parseDouble(input);
                            break;
                        }else{
                            System.out.println("Valor incorrecto.Ingrese un numero valido y positivo");
                        }
                    }

                    gestor.agregarElectrodomestico(nombre, consumo);
                    System.out.println("Dispositivo ingresado correctamente");
                    break;
                }
                case 2: {
                    System.out.print("Nombre del electrodoméstico a eliminar: "); // ***MEJORA: Clarificar el mensaje***
                    gestor.eliminarElectrodomestico(sc.nextLine());
                    break;
                }
                case 3: {
                    List<Electrodomestico> dispositivos = gestor.getDispositivos(); // ***CORRECCIÓN/MEJORA: Usar tipo específico***
                    if (dispositivos.isEmpty()) {
                        System.out.println("No hay electrodomésticos registrados.");
                    } else {
                        System.out.println("\n--- Dispositivos Registrados ---");
                        for (Electrodomestico d : dispositivos) { // ***MEJORA: Bucle for-each***
                            System.out.println(d);
                        }
                    }
                    break;
                }
                case 4: {
                    List<String> fuentes = gestor.getFuentesDisponibles(); // ***CORRECCIÓN/MEJORA: Usar tipo específico***
                    if (fuentes.isEmpty()) {
                        System.out.println("No hay fuentes de energía disponibles.");
                    } else {
                        System.out.println("\n--- Fuentes de Energía Disponibles ---");
                        for (String f : fuentes) { // ***MEJORA: Bucle for-each***
                            System.out.println(f);
                        }
                    }
                    break;
                }
                case 5: {

                    String fuente;
                    while (true) {
                    System.out.print("Ingrese el nombre de la fuente de energía (Solar , Red o Eolica): "); // ***MEJORA: Guía al usuario***
                    fuente = sc.nextLine();
                    if (Validaciones.ValidarFENombre(fuente)){
                        break;
                    }else{
                            System.out.println("El nombre solo debe contener letras.Intente nuevamente");
                    }
                    
                    }    

                    double horas;
                    while (true) {
                    System.out.print("Ingrese el número de horas a simular: ");
                    String input = sc.nextLine();

                    if (Validaciones.ValidarFEHoras(input)) {
                        horas = Double.parseDouble(input);
                        break;
                    }else{
                            System.out.println("Valor incorrecto.Ingrese un numero valido y positivo");
                    }
                    }

                    gestor.simularConsumo(fuente, horas);
                    break;
                }
                case 6: {
                    List<RegistroConsumo> historial = gestor.getHistorial();
                    if (historial.isEmpty()) {
                        System.out.println("El historial de consumo está vacío.");
                    } else {
                        System.out.println("\n--- Historial de Consumo ---");
                        for (RegistroConsumo r : historial) { // ***MEJORA: Bucle for-each***
                            System.out.println(r.getResumen());
                        }
                    }
                    break;
                }
                case 7: {
                    Stack<String> acciones = gestor.getAcciones(); // ***CORRECCIÓN/MEJORA: Usar tipo específico Stack***
                    if (acciones.isEmpty()) {
                        System.out.println("No se han registrado acciones.");
                    } else {
                        System.out.println("\n--- Historial de Acciones ---");
                        // Iterar una copia para no vaciar el stack original si se quiere deshacer
                        for (String accion : acciones) { // ***MEJORA: Bucle for-each***
                            System.out.println(accion);
                        }
                    }
                    break;
                }
                case 8: {
                    System.out.println("Gracias por usar EcoImpactDev. ¡Hasta pronto!"); // ***MEJORA: Mensaje de despedida***
                    sc.close(); // Cerrar el scanner
                    return;
                }
                default: {
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 9."); // ***MEJORA: Mensaje de error más específico***
                    break;
                }
            }
        }
    }
}