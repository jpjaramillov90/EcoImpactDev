package com.uisrael.eagleDev.resources;

public class MenuDisplay {

    public void seeHeaderv () {
        System.out.println("\n" +
                " ______         _____                            _   _____             \n" +
                "|  ____|       |_   _|                          | | |  __ \\            \n" +
                "| |__   ___ ___  | |  _ __ ___  _ __   __ _  ___| |_| |  | | _____   __\n" +
                "|  __| / __/ _ \\ | | | '_ ` _ \\| '_ \\ / _` |/ __| __| |  | |/ _ \\ \\ / /\n" +
                "| |___| (_| (_) || |_| | | | | | |_) | (_| | (__| |_| |__| |  __/\\ V / \n" +
                "|______\\___\\___/_____|_| |_| |_| .__/ \\__,_|\\___|\\__|_____/ \\___| \\_/  \n" +
                "                               | |                                     \n" +
                "                               |_|                                     ");
        System.out.println("\n=== INTEGRANTES ===");
        System.out.println("Jaramillo Villalba Joao Paul");
        System.out.println("Mendez Paredes Mayerli Yael");
        System.out.println("Morales Freire Stefi Gabriela ");
    }

    public void seeMenu () {
        System.out.println("\n");
        System.out.println("1. Agregar dispositivo");
        System.out.println("2. Eliminar dispositivo");
        System.out.println("3. Ver dispositivos");
        System.out.println("4. Ver fuentes disponibles");
        System.out.println("5. Simular consumo");
        System.out.println("6. Ver historial");
        System.out.println("7. Ver acciones");
        System.out.println("8. Salir");
        System.out.print("Opción: ");
    }

}
