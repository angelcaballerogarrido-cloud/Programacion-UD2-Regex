package com.mycompany.ejercicioregex1; 

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjercicioRegex2 {

    public static void main(String[] args) {
        
    
        String texto = "En un mundo dominado por los gatos el perro es el mejor aliado ya que los gatos son felinos mientras que los perros caninos.\n" +
                       "Los gatos y los perros son dos de las mascotas más populares del mundo. Ambos tienen sus ventajas y desventajas...\n" +
                       "- **Personalidad**: Los gatos suelen ser más independientes y tranquilos que los perros...\n" +
                       "Los gatos pueden pasar más tiempo solos... mientras que los perros necesitan más atención...\n" +
                       "- **Cuidados**: Los gatos y los perros requieren diferentes tipos de cuidados.\n" +
                       "- **Costes**: Tener una mascota implica un gasto económico... Los gatos y los perros tienen costes similares...";

        System.out.println("--- TEXTO ORIGINAL ---");
        System.out.println(texto);
        
        
        StringBuffer sb = new StringBuffer();
       
        String regex = "(?i)\\b(gato|perro|felino|canino)(s?)\\b";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(texto);
        
        while (m.find()) {
        
            String palabraBase = m.group(1).toLowerCase();
            String plural = m.group(2); // Captura la "s" si la hay
            
            String reemplazo = "";
            
            switch (palabraBase) {
                case "gato":
                    reemplazo = "perro";
                    break;
                case "perro":
                    reemplazo = "gato";
                    break;
                case "felino":
                    reemplazo = "canino";
                    break;
                case "canino":
                    reemplazo = "felino";
                    break;
            }
            
           
            
            // Añadimos la 's' si era plural
            reemplazo = reemplazo + plural;
            
            // Hacemos el cambio en el buffer
            m.appendReplacement(sb, reemplazo);
        }
        
        m.appendTail(sb);
        
        System.out.println("\n--- TEXTO CAMBIADO (SWAP COMPLETO) ---");
        System.out.println(sb.toString());
    }
}