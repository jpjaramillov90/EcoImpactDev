package com.uisrael.eagleDev.core;

public class Validaciones {
    
    public static boolean ValidarNombre(String nombre){
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+");
    }

    public static boolean ValidarConsumo(String input){
        try{
            double valor = Double.parseDouble(input);
            return valor >0;
        }catch (NumberFormatException exception){
            return false;
        }
    }

}
