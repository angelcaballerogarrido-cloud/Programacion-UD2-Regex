package ejercicioregex1; 
public class EjercicioRegex1 {

    public static void main(String[] args) {
        
        // 1. Guardamos el texto original en una variable String
        // Nota: He puesto todo el texto seguido para facilitar el código.
        String historia = "{Un hombre} va al médico porque tiene un problema muy grave: "
                + "cada vez que estornuda, {} se convierte en un animal diferente. "
                + "{El médico} le dice que es un caso muy raro y que necesita hacerle unas pruebas. "
                + "{Le} pone unos electrodos en la cabeza y le conecta a una máquina que mide su actividad cerebral. "
                + "- Bien, ahora voy a provocarle un estornudo con este spray nasal y veremos qué pasa - dice {el médico}. "
                + "- Vale, pero tenga cuidado, no sé en qué me voy a convertir - dice {el hombre}. "
                + "- No se preocupe, tengo una jaula preparada por si acaso - dice {el médico}. "
                + "{El médico} le aplica el spray nasal al hombre y este empieza a estornudar...";

        // --- SOLUCIÓN ---

        // PASO A: Definir el nombre del médico y su expresión regular
        String nombreMedico = "Angel";
        // Explicación Regex Médico:
        // \\{        -> Busca una llave de apertura literal
        // (El médico|el médico|Le) -> Busca CUALQUIERA de estas tres opciones exactas
        // \\}        -> Busca una llave de cierre literal
        String regexMedico = "\\{(El médico|el médico|Le)\\}";

        
        // PASO B: Definir el nombre del hombre y su expresión regular
        String nombreHombre = "Angel";
        // Explicación Regex Hombre:
        // \\{        -> Busca llave apertura
        // (Un hombre|el hombre|) -> Busca "Un hombre" O "el hombre" O nada (para el caso de {})
        // \\}        -> Busca llave cierre
        String regexHombre = "\\{(Un hombre|el hombre|)\\}";

        
        // PASO C: Aplicar los reemplazos
        // Primero reemplazamos al médico en el texto
        String resultado = historia.replaceAll(regexMedico, nombreMedico);
        
        // Sobre el resultado anterior, reemplazamos al hombre
        resultado = resultado.replaceAll(regexHombre, nombreHombre);

        
        // PASO D: Mostrar en pantalla
        System.out.println("--- TEXTO ORIGINAL ---");
        System.out.println(historia);
        System.out.println("\n--- TEXTO MODIFICADO ---");
        System.out.println(resultado);
    }
}