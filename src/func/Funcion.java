package func;

import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jhonatan
 */
public class Funcion {
    public static HashMap<String, List<HashMap<String, String>>> archivosJson = new HashMap<>(); 
    public static HashMap archivoLocalJson = new HashMap(); 
    public static int contador = 0;
    
    public static LinkedList<Object> lista = new LinkedList<>();
    
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
