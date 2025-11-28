package com.mycompany.ejercicioregex1; 

public class EjercicioRegex1 {

    public static void main(String[] args) {
   
        String historia = "{Un hombre} va al médico porque tiene un problema muy grave: "
                + "cada vez que estornuda, {} se convierte en un animal diferente. "
                + "{El médico} le dice que es un caso muy raro y que necesita hacerle unas pruebas. "
                + "{Le} pone unos electrodos en la cabeza y le conecta a una máquina que mide su actividad cerebral. "
                + "- Bien, ahora voy a provocarle un estornudo con este spray nasal y veremos qué pasa - dice {el médico}. "
                + "- Vale, pero tenga cuidado, no sé en qué me voy a convertir - dice {el hombre}. "
                + "- No se preocupe, tengo una jaula preparada por si acaso - dice {el médico}. "
                + "{El médico} le aplica el spray nasal al hombre y este empieza a estornudar...";

        String nombreMedico = "Dr. House";
        String regexMedico = "\\{(El médico|el médico|Le)\\}";

        
        String nombreHombre = "Angel";
        String regexHombre = "\\{(Un hombre|el hombre|)\\}";
        String resultado = historia.replaceAll(regexMedico, nombreMedico);

        resultado = resultado.replaceAll(regexHombre, nombreHombre);
        System.out.println("--- TEXTO ORIGINAL ---");
        System.out.println(historia);
        System.out.println("\n--- TEXTO MODIFICADO ---");
        System.out.println(resultado);
    }
}