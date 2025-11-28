package ejercicioregex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjercicioRegex3 {

    public static void main(String[] args) {

        String texto = "El lobo sopló y sopló pero la casa de madera no se cayó. "
                + "Madera ummm. Entonces pensó, ¿y si en vez de usar mis pulmones uso un palo de madera?. "
                + "Fue entonces cuando buscó por todo el bosque pero sólo encontraba maderas gordas que no podía transportar. "
                + "A lo mejor haciendo una carretilla de madera podría transportar algo más grande y usarlo "
                + "para aporrear con fuerza la casita de madera...";

        System.out.println("--- TEXTO ORIGINAL ---");
        System.out.println(texto);

        StringBuffer sb = new StringBuffer();


        String regex = "(?i)\\bmadera\\b";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(texto);

        int contador = 0; 
        while (m.find()) {
            contador++; 
            
            
            if (contador == 2 || contador == 4) {
                m.appendReplacement(sb, "METAL");
            } else {
            
                m.appendReplacement(sb, m.group());
            }
        }
        
        m.appendTail(sb);
        
        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.println(sb.toString());
    }
}
