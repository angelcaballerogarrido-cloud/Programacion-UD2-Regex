package com.mycompany.ExtractorColores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjercicioRegexHTML {

    public static void main(String[] args) {

       
        String html = "<!DOCTYPE html>\n"
                + "<html lang=\"es\">\n"
                + "<body>\n"
                + "    <div class=\"contenedor\">\n"
                + "        <div class=\"elemento rojo-color\">Esto 12 es rojo</div>\n"
                + "        <div class=\"elemento azul-color\">Esto se 23 ve en Azul</div>\n"
                + "        <div class=\"elemento verde-color\">Esto es 24 verde</div>\n"
                + "        <div class=\"elemento color-amarillo\">Esto parece 44 amarillo</div>\n"
                + "        <div class=\"elemento color-purpura\">Puede ser purpura 55</div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";

        System.out.println("--- ANÁLISIS HTML ---");
        
       
        String regexDiv = "class=\"elemento\\s+([^\"]+)\">([^<]+)</div>";
        
        Pattern p = Pattern.compile(regexDiv);
        Matcher m = p.matcher(html);

        while (m.find()) {
           
            String estiloColor = m.group(1); 
            String textoDiv = m.group(2);    
            
           
            Matcher mNum = Pattern.compile("\\d+").matcher(textoDiv);
            
            String numero = "0"; 
            if (mNum.find()) {
                numero = mNum.group();
            }

            
            System.out.println("(" + estiloColor + ") --> {" + textoDiv + "} - [" + numero + "]");
        }
    }
}