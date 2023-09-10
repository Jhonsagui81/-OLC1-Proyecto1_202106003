package func;

import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.LinkedList;

/**
 *
 * @author Jhonatan
 */
public class Funcion {
    public static HashMap archivosJson = new HashMap(); 
    public static int contador = 0;
    
    public static LinkedList<Object> lista = new LinkedList<>();
    
    public static void mostrar(String texto){
        JOptionPane.showMessageDialog(null,texto);
    }
}
