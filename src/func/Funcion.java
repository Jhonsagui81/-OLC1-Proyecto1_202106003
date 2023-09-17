package func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Jhonatan
 */
public class Funcion {
    public static HashMap<String, List<HashMap<String, String>>> archivosJson = new HashMap<>(); 
    public static HashMap archivoLocalJson = new HashMap(); 
    
    //HashMap para almacenar def VARIABLES GLOBALES 
    public static HashMap<String, String> variablesGlobales = new HashMap<>();
    
    
    //para establecer #caso default
    public static int contadorCase = 0;
    //Para almacenar codigo traducido 
    public static String codigo = "";
    //Para tener control de la tabulacion
    public static LinkedList<String> pila = new LinkedList<>();
    
   public static void agregarTab(String x){
       if (x.equals("{")){
           System.out.println("SE AGERGASS \\t");
           pila.add("\t");
       }else{
           System.out.println("NO COINCIDE {");
       }
   }
   
   public static void EliminarTab(String x){
       if (x.equals("}")){
           pila.pop();
       }
   }
   
   public static String retornTabs(){
       String tabs = "";
       Iterator<String> iterador = pila.iterator();
       while (iterador.hasNext()) {
            String elemento = iterador.next();
            System.out.println("El elemento a conatenar es: "+elemento);
            
        }
       System.out.println("Lo que se retorna es: "+tabs);
       return tabs;
   }
    
    public static LinkedList<Object> lista = new LinkedList<>();
    
    //HashMap para GRAFICAAAAAA BARRAS -----------------------------------------<<>>
    public static Map<String, List<String>> Hash_barras = new HashMap<>();
    
    //Lista para grafica de barras 
    public static List<String> Titulo = new ArrayList<>();
    public static List<String> EjeX = new ArrayList<>();
    public static List<String> Valores = new ArrayList<>();
    public static List<String> TituloX = new ArrayList<>();
    public static List<String> TituloY = new ArrayList<>();
    
    //Contadores para extraer informacion
    public static int contador_valores = 0;
    
    public static void mostrarDataBarras(){
        for (String clave : Hash_barras.keySet()) {
            System.out.println("Clave: " + clave);
            List<String> valores = Hash_barras.get(clave);
            System.out.println("Valores:");
            for (String valor : valores) {
                System.out.println("  " + valor);
            }
        }
    }
    
    public static int columnasGraficaBarras(){
        int columnas = 0;
        
        for (String clave : Hash_barras.keySet()) {
            if(clave.equalsIgnoreCase("Valores")){
                List<String> valores = Hash_barras.get(clave);
                columnas = valores.size();
            }
        }
        return columnas;
    }
    
    public static double valoresBarras(){
        double valorR = 0;
        int contadorlocal = 0;
        for (String clave : Hash_barras.keySet()) {
            if(clave.equalsIgnoreCase("Valores")){
                List<String> valores = Hash_barras.get(clave);
                for (String valor : valores) {
                    if (contadorlocal == contador_valores){
                        valorR = Double.parseDouble(valor);
                    }
                    contadorlocal++;
                }
            }
        } 
        return valorR; 
    }
    
    public static String ejeXBarras(){
        String ejex = "";
        int contadorlocal = 0;
        for (String clave : Hash_barras.keySet()) {
            if(clave.equalsIgnoreCase("EjeX")){
                List<String> valores = Hash_barras.get(clave);
                for (String valor : valores) {
                    if (contadorlocal == contador_valores){
                        ejex = valor.toString();
                    }
                    contadorlocal++;
                }
            }
        } 
        return ejex; 
    }
    
    public static String TituloBarras(){
        String ejex = "";
        for (String clave : Hash_barras.keySet()) {
            if(clave.equalsIgnoreCase("Titulo")){
                List<String> valores = Hash_barras.get(clave);
                for (String valor : valores) {
                    ejex = valor.toString();
                }
            }
        } 
        return ejex; 
    }
    
    public static String TituloXGraficaBarras(){
        String ejex = "";
        for (String clave : Hash_barras.keySet()) {
            if(clave.equalsIgnoreCase("TituloX")){
                List<String> valores = Hash_barras.get(clave);
                for (String valor : valores) {
                    ejex = valor.toString();
                }
            }
        } 
        return ejex; 
    }
    
    public static String TituloYGraficaBarras(){
        String ejex = "";
        for (String clave : Hash_barras.keySet()) {
            if(clave.equalsIgnoreCase("TituloY")){
                List<String> valores = Hash_barras.get(clave);
                for (String valor : valores) {
                    ejex = valor.toString();
                }
            }
        } 
        return ejex; 
    }
    
       //HashMap para GRAFICAAAAAA pie -----------------------------------------<<>>
    public static Map<String, List<String>> Hash_pie = new HashMap<>();
    
    //Lista para grafica de barras 
    public static List<String> Titulo_pie = new ArrayList<>();
    public static List<String> EjeX_pie = new ArrayList<>();
    public static List<String> Valores_pie = new ArrayList<>();
    
    
    
    public static int PorcionesGraficaPie(){
        int columnas = 0;
        
        for (String clave : Hash_pie.keySet()) {
            if(clave.equalsIgnoreCase("Valores")){
                List<String> valores = Hash_pie.get(clave);
                columnas = valores.size();
            }
        }
        return columnas;
    }
    
    public static double valoresGraficaPie(){
        double valorR = 0;
        int contadorlocal = 0;
        for (String clave : Hash_pie.keySet()) {
            if(clave.equalsIgnoreCase("Valores")){
                List<String> valores = Hash_pie.get(clave);
                for (String valor : valores) {
                    if (contadorlocal == contador_valores){
                        valorR = Double.parseDouble(valor);
                    }
                    contadorlocal++;
                }
            }
        } 
        return valorR; 
    }
    
    public static String ejeXGraficaPie(){
        String ejex = "";
        int contadorlocal = 0;
        for (String clave : Hash_pie.keySet()) {
            if(clave.equalsIgnoreCase("EjeX")){
                List<String> valores = Hash_pie.get(clave);
                for (String valor : valores) {
                    if (contadorlocal == contador_valores){
                        ejex = valor.toString();
                    }
                    contadorlocal++;
                }
            }
        } 
        return ejex; 
    }
    
    public static String TituloPie(){
        String ejex = "";
        for (String clave : Hash_pie.keySet()) {
            if(clave.equalsIgnoreCase("Titulo")){
                List<String> valores = Hash_pie.get(clave);
                for (String valor : valores) {
                    ejex = valor.toString();
                }
            }
        } 
        return ejex; 
    }
    
    
    //---------------------------------------------------------------------------
    public static String buscaIdGlobal(String id){
        String valor = "";
        System.out.println("parametro barras: "+id);
        if (variablesGlobales.containsKey(id)) {
            String valorencon = variablesGlobales.get(id);
            valor = valorencon;
            System.out.println("El valor asociado a " + id + " es: " + valor);
        } else {
            System.out.println("La clave " + id + " no existe en el HashMap.");
        }
        
        
        return valor; 
    }
    
    public static String buscaEstruc(String archivoBus, String claveBus){
        String valorBus = "";
        for (Map.Entry<String, List<HashMap<String, String>>> entry : archivosJson.entrySet()) {
            String archivo = entry.getKey();
            List<HashMap<String, String>> archivosData = entry.getValue();
            System.out.println("---------------- validacion nombres ---------------");
            System.out.println("nombreparam: "+archivoBus);
            System.out.println("nombreIter: "+archivo);
            if (archivoBus.equals(archivo)){
                System.out.println("Archivo: " + archivo);
                for (HashMap<String, String> archivoData : archivosData) {
                    for (Map.Entry<String, String> innerEntry : archivoData.entrySet()) {
                        String clave = innerEntry.getKey();
                        String valor = innerEntry.getValue();
                        //validacion de la clave 
                        if(claveBus.equals(clave)){
                            valorBus = valor;
                        }
                       
                    }
                }
            }
        }
        return valorBus; 
    }
    
    
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
    
    public static String nombre(String cadena){
        String patron = "\"([^\"]*)\"";
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
