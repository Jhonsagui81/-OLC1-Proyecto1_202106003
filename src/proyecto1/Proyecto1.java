
package proyecto1;
//importar las clases analizadores

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




/**
 *
 * @author Jhonatan
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static String file = "";
    public static int contadorHash = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        String codigoFuente = """
                              {   
                              //comentario inline
                              "Titulo":1, 
                              "variable":"titulo21",
                              "maryin":2,
                              /*
                              comentario
                              multi
                              inline xd
                              */
                              "Tituloescd":"titulo barras",
                              "titulo":35,  ``~~
                              "Titulo1":45.2,
                              "Titulo":78
                              }
                              ~~
                              """;
//        analizadores("src/Analizador/", "Scanner.jflex", "Parser.cup");
//        System.out.println("Este es el codigo fuente: " +codigoFuente);
        System.out.println("----------------------------------------");
//        func.Funcion.lista.add("Hola");
//        
        
//        func.Funcion.lista.forEach((elemento)->{
//            System.out.println(elemento.toString());
//        });
       // analizar(codigoFuente);
        
        
        
   
                Interfaz.Pantalla Interfaz = new Interfaz.Pantalla();
                Interfaz.setVisible(true);
                
                
    }
    
    public static void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
    
    //Realizar analisis
    public static void analizar (String entrada){
        try {
            Analizador.scanner scanner = new Analizador.scanner(new StringReader(entrada)); 
            Analizador.Parser parser = new Analizador.Parser(scanner);
            parser.parse();
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        } 
    }
    
    //Realizar analizar en la interfaz 
    public static void compilarjson(String codigo, String files){
        file = files;
    }
    
    public static void carga(String x, String y){
        HashMap<String, String> archivoDato = new HashMap<>();
        archivoDato.put(x, y);
        
        List<HashMap<String, String>> archivosData = func.Funcion.archivosJson.getOrDefault(file, new ArrayList<>());
        archivosData.add(archivoDato);

        
        func.Funcion.archivosJson.put(file, archivosData);
    }
}