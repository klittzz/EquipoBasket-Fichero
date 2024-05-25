package main.util;

public class Aa {

    public static void bonito(String texto){
        String lineas = "------";
        for (int i = 0; i < texto.length(); i++) {
            lineas += "-";
        }
        System.out.println(Ansi.RED + lineas + Ansi.WHITE);        
        System.out.println("-- " + texto + " --" + Ansi.WHITE);
        System.out.println(Ansi.RED + lineas + Ansi.WHITE);
    }
}
