package com.mycompany.ejercicioregex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjercicioRegex4 {

    public static void main(String[] args) {

       
        System.out.println("--- EJERCICIO 1: Texto entre comillas ---");
        
        String texto1 = "El hombre dijo 'El perro no sabe leer' y el perro le contestó "
                + "'Si me hubieras preguntado sabrías la verdad'. 'Cuál es la verdad' preguntó el hombre. "
                + "'La verdad es ...' y el perro sonó como 'aaaaagh'.";

       
        String regex1 = "'(.*?)'";

        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(texto1);

        while (m1.find()) {
         
            System.out.println("Encontrado: " + m1.group(1));
        }

        System.out.println("\n");

       
        // PARTE 2: DINERO EN LIBRAS (LOOKAROUND)
        String texto2 = "250 Euros es el dinero que me dio cuando yo le presté 200$ ¿o fueron "
                + "220 libras?, ya no me acuerdo. Debo de estar perdiendo la memoria ya "
                + "sé eran 120Libras. Cuando dijiste 100 Libraste una batalla. Entonces sería "
                + "que quería darte 100 Librasilios, qué es 1 Librasilio, 10 Librasilios son 10 "
                + "veces 1 Librasillo. Entonces 1 Libra ¿no? Sí, sí, 1 libra.";

 
        String regex2 = "\\d+(?=\\s*(?i)libras?\\b)";

        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(texto2);

        while (m2.find()) {
     
            System.out.println("Dinero encontrado: " + m2.group());
        }
    }
}