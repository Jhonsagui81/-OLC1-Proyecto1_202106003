
package proyecto1;
//importar las clases analizadores

import java.io.StringReader;



/**
 *
 * @author Jhonatan
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
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
        System.out.println("Este es el codigo fuente: " +codigoFuente);
        System.out.println("----------------------------------------");
//        func.Funcion.lista.add("Hola");
//        
        
//        func.Funcion.lista.forEach((elemento)->{
//            System.out.println(elemento.toString());
//        });
        analizar(codigoFuente);
        
        System.out.println("----- Termino el analisis ------------------");
        System.out.println("tokens de los json: ");
        func.Funcion.archivosJson.forEach((t, u)-> {
            System.out.println(t.toString() + "=" + u.toString());
        });
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
}
