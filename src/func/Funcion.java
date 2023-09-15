package func;

import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;
import java.util.Map;

/**
 *
 * @author Jhonatan
 */
public class Funcion {
    public static HashMap<String, List<HashMap<String, String>>> archivosJson = new HashMap<>(); 
    public static HashMap archivoLocalJson = new HashMap(); 
    //para establecer #caso default
    public static int contadorCase = 0;
    //Para almacenar codigo traducido 
    public static String codigo = "";
    
    public static LinkedList<Object> lista = new LinkedList<>();
    
    public static String numero(String cadena){
        String patron = "[0-9]+";
        String numero = "";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);
        
        if (matcher.find()) {
            // Extraer el fragmento que coincide con la expresión regular
            numero = matcher.group();
       
        } else {
            System.out.println("Número de teléfono no encontrado.");
        }
        return numero; 
    }
    
    public static String id(String cadena){
        String patron = "[a-zA-ZÑñ]([a-zA-ZÑñ]|[0-9]+|_)*";
        String numero = "";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);
        
        if (matcher.find()) {
            // Extraer el fragmento que coincide con la expresión regular
            numero = matcher.group();
       
        } else {
            System.out.println("Número de teléfono no encontrado.");
        }
        return numero; 
    }
    
    public static void mostrar(){
        for (Map.Entry<String, List<HashMap<String, String>>> entry : archivosJson.entrySet()) {
            String archivo = entry.getKey();
            List<HashMap<String, String>> archivosData = entry.getValue();

            System.out.println("Archivo: " + archivo);

            for (HashMap<String, String> archivoData : archivosData) {
                for (Map.Entry<String, String> innerEntry : archivoData.entrySet()) {
                    String clave = innerEntry.getKey();
                    String valor = innerEntry.getValue();

                    System.out.println("  Clave: " + clave + ", Valor: " + valor);
                }
            }
        }
    }
}
