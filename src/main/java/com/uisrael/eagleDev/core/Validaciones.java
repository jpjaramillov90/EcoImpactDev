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

    
    public static boolean ValidarFENombre(String fuente){
        return fuente.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+");
    }

        public static boolean ValidarFEHoras(String input){
        try{
            double horas = Double.parseDouble(input);
            return horas >0;
        }catch (NumberFormatException exception){
            return false;
        }
    }

}
