package statpy;
import java_cup.runtime.*;
// importar arraylist
//import java.util.ArrayList;       <-
// importar clase de excepciones
//import Errores.Exception_ ;       <-
%%


%{
    //Código de usuario
    // declarar un arraylist para los errores lexicos
    //public  static ArrayList<Exception_> erroresLexicos = new ArrayList<Exception_>() ;   <-
%}

%class lexer  // definir como trabajara el scanner 
%cup            // trabajar con cup 
%public         // tipo publico
%line           // conteo de lineas - linea por linea
%char 
%unicode        // tipo de codigicacion para que acepte la  ñ u otro caracter
%ignorecase     // case insensitive 

%init{ 
    yyline = 1;
    yycolumn =1;
%init}

//expresiones
ENTERO  = [0-9]+   
DECIMAL = [0-9]+("."[  |0-9]+)?
LETRA   = [a-zA-ZÑñ]
ID      = {LETRA}({LETRA}|{ENTERO}|"_")*
CADENA  = [\"][^\"\n]+[\"]
SPACE   = [\ \r\t\f\t]
ENTER   = \r|\n|\r\n
CARACTER = [^\r\n]
COMENTARIOLINEA = "//" {CARACTER}* {ENTER}?
COMENTARIOMULTILINEA = "/*" [^/]~ "*/"

//simbolos
PAR_IZQ     = "("
PAR_DER     = ")"
LLAV_IZQ    = "{"
LLAV_DER    = "}" 
COR_IZQ     = "["
COR_DER     = "]"
DOLLAR      = "$"
IGUAL       = "="
MAYOR_QUE   = ">"
MENOR_QUE   = "<"
MAYOR_IGUAL = ">="
MENOR_IGUAL = "<="
COMPARADOR  = "=="
DISTINTO    = "!="
AND         = "&&"
OR          = "||"
NOT         = "!"
PTCOMA      = ";"
COMA        = ","
PUNTO       = "."
DOSPUNTOS   = ":"
VACIO = ""
MAS = "+"
MENOS = "-"
POR = "*"
DIV = "/"
//COMILLA_SIMPLE = \\'
//COMILLA_DOBLE = \\\"


//palabras reservadas
RVOID = "void"
RMAIN = "main"
RDEFGLOBAL = "DefinirGlobales"
RNEWVALOR = "NewValor"
RGRAFIBARRAS = "GraficaBarras"
RGRAFIPIE = "GraficaPie"
RINT = "int"
RDOUBLE = "double"
RCHAR = "char"
RBOOL = "bool"
RSTRING = "string"
RIF = "if"
RELSE = "else"
RSWITCH = "switch"
RBREAK = "break"
RCASE = "case"
RDEFAU = "default"
RFOR = "for"
RWHILE = "while"
RDOWHILE = "do"
RCONSOLA = "Console"
RWRITE = "Write"
RTRUE = "True"
RFALSE = "False"

RTITULO = "Titulo"
REJEX = "EjeX"
RVALOR = "Valores"
RTITULOX = "TituloX"
RTITULOY = "TituloY"

%%

<YYINITIAL> {RVOID}  {   return new Symbol(sym.RVOID, yyline, yycolumn,yytext());  }
<YYINITIAL> {RMAIN}  {   return new Symbol(sym.RMAIN, yyline, yycolumn,yytext());  }
<YYINITIAL> {RDEFGLOBAL}  {   return new Symbol(sym.RDEFGLOBAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {RNEWVALOR}  {   return new Symbol(sym.RNEWVALOR, yyline, yycolumn,yytext());  }
<YYINITIAL> {RGRAFIBARRAS}  {   return new Symbol(sym.RGRAFIBARRAS, yyline, yycolumn,yytext());  }
<YYINITIAL> {RGRAFIPIE}  {   return new Symbol(sym.RGRAFIPIE, yyline, yycolumn,yytext());  }
<YYINITIAL> {RINT}   {   return new Symbol(sym.RINT, yyline, yycolumn,yytext());   }
<YYINITIAL> {RDOUBLE}    {   return new Symbol(sym.RDOUBLE, yyline, yycolumn,yytext());    }
<YYINITIAL> {RCHAR}  {   return new Symbol(sym.RCHAR, yyline, yycolumn,yytext());  }
<YYINITIAL> {RBOOL}  {   return new Symbol(sym.RBOOL, yyline, yycolumn,yytext());  }
<YYINITIAL> {RSTRING}    {   return new Symbol(sym.RSTRING, yyline, yycolumn,yytext());    }
<YYINITIAL> {RIF}    {   return new Symbol(sym.RIF, yyline, yycolumn,yytext());    }
<YYINITIAL> {RELSE}    {   return new Symbol(sym.RELSE, yyline, yycolumn,yytext());    }
<YYINITIAL> {RSWITCH}    {   return new Symbol(sym.RSWITCH, yyline, yycolumn,yytext());    }
<YYINITIAL> {RBREAK}    {   return new Symbol(sym.RBREAK, yyline, yycolumn,yytext());    }
<YYINITIAL> {RCASE}    {   return new Symbol(sym.RCASE, yyline, yycolumn,yytext());    }
<YYINITIAL> {RDEFAU}    {   return new Symbol(sym.RDEFAU, yyline, yycolumn,yytext());    }
<YYINITIAL> {RFOR}    {   return new Symbol(sym.RFOR, yyline, yycolumn,yytext());    }
<YYINITIAL> {RWHILE}    {   return new Symbol(sym.RWHILE, yyline, yycolumn,yytext());    }
<YYINITIAL> {RDOWHILE}    {   return new Symbol(sym.RDOWHILE, yyline, yycolumn,yytext());    }
<YYINITIAL> {RCONSOLA}    {   return new Symbol(sym.RCONSOLA, yyline, yycolumn,yytext());    }
<YYINITIAL> {RWRITE}    {   return new Symbol(sym.RWRITE, yyline, yycolumn,yytext());    }

<YYINITIAL> {RTITULO}    {   return new Symbol(sym.RTITULO, yyline, yycolumn,yytext());    }
<YYINITIAL> {REJEX}    {   return new Symbol(sym.REJEX, yyline, yycolumn,yytext());    }
<YYINITIAL> {RVALOR}    {   return new Symbol(sym.RVALOR, yyline, yycolumn,yytext());    }
<YYINITIAL> {RTITULOX}    {   return new Symbol(sym.RTITULOX, yyline, yycolumn,yytext());    }
<YYINITIAL> {RTITULOY}    {   return new Symbol(sym.RTITULOY, yyline, yycolumn,yytext());    }

<YYINITIAL> {PAR_IZQ}   {   return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {PAR_DER}   {   return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());  }
<YYINITIAL> {LLAV_IZQ}  {   return new Symbol(sym.LLAV_IZQ, yyline, yycolumn,yytext()); }
<YYINITIAL> {DOLLAR}    {   return new Symbol(sym.DOLLAR, yyline, yycolumn,yytext()); }
<YYINITIAL> {LLAV_DER}  {   return new Symbol(sym.LLAV_DER, yyline, yycolumn,yytext()); }
<YYINITIAL> {COR_IZQ}   {   return new Symbol(sym.COR_IZQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {COR_DER}   {   return new Symbol(sym.COR_DER, yyline, yycolumn,yytext());  }
<YYINITIAL> {IGUAL}     {   return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());    }
<YYINITIAL> {PTCOMA}    {   return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());   }
<YYINITIAL> {MAYOR_QUE}    {   return new Symbol(sym.MAYOR_QUE, yyline, yycolumn,yytext());   }
<YYINITIAL> {MENOR_QUE}    {   return new Symbol(sym.MENOR_QUE, yyline, yycolumn,yytext());   }
<YYINITIAL> {COMA}    {   return new Symbol(sym.COMA, yyline, yycolumn,yytext());   }
<YYINITIAL> {PUNTO}    {   return new Symbol(sym.PUNTO, yyline, yycolumn,yytext());   }
<YYINITIAL> {MAYOR_IGUAL}    {   return new Symbol(sym.MAYOR_IGUAL, yyline, yycolumn,yytext());   }
<YYINITIAL> {MENOR_IGUAL}    {   return new Symbol(sym.MENOR_IGUAL, yyline, yycolumn,yytext());   }
<YYINITIAL> {COMPARADOR}    {   return new Symbol(sym.COMPARADOR, yyline, yycolumn,yytext());   }
<YYINITIAL> {DISTINTO}    {   return new Symbol(sym.DISTINTO, yyline, yycolumn,yytext());   }
<YYINITIAL> {AND}    {   return new Symbol(sym.AND, yyline, yycolumn,yytext());   }
<YYINITIAL> {OR}    {   return new Symbol(sym.OR, yyline, yycolumn,yytext());   }
<YYINITIAL> {NOT}    {   return new Symbol(sym.NOT, yyline, yycolumn,yytext());   }
<YYINITIAL> {DOSPUNTOS}    {   return new Symbol(sym.DOSPUNTOS, yyline, yycolumn,yytext());   }
<YYINITIAL> {RTRUE}    {   return new Symbol(sym.RTRUE, yyline, yycolumn,yytext());   }
<YYINITIAL> {RFALSE}    {   return new Symbol(sym.RFALSE, yyline, yycolumn,yytext());   }
<YYINITIAL> {VACIO}    {   return new Symbol(sym.VACIO, yyline, yycolumn,yytext());   }

//<YYINITIAL> {COMILLA_SIMPLE}    {   return new Symbol(sym.COMILLA_SIMPLE, yyline, yycolumn,yytext());   }
//<YYINITIAL> {COMILLA_DOBLE}    {   return new Symbol(sym.COMILLA_DOBLE, yyline, yycolumn,yytext());   }

<YYINITIAL> {MAS}       {   return new Symbol(sym.MAS, yyline, yycolumn,yytext());  }
<YYINITIAL> {MENOS}     {   return new Symbol(sym.MENOS, yyline, yycolumn,yytext());    }
<YYINITIAL> {POR}       {   return new Symbol(sym.POR, yyline, yycolumn,yytext());   }
<YYINITIAL> {DIV}       {   return new Symbol(sym.DIV, yyline, yycolumn,yytext());   }
<YYINITIAL> {ENTERO}    {   return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());   }
<YYINITIAL> {CADENA}    {   return new Symbol(sym.CADENA, yyline, yycolumn,yytext());   }
<YYINITIAL> {DECIMAL}   {   return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {ID}        {   return new Symbol(sym.ID, yyline, yycolumn,yytext());   }

<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}

<YYINITIAL> {COMENTARIOLINEA} { /*Comentarios de una linea, ignorados*/ System.out.println("Comentario de una linea: "+yytext() ); }
<YYINITIAL> {COMENTARIOMULTILINEA} { /*Comentarios multilinea, ignorados*/ System.out.println("Comentario multilinea: "+yytext() ); }
<YYINITIAL> . {
        // agregar errores lexicos 
        //String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        //System.out.println(errLex);
        //erroresLexicos.add(new Exception_ ("Léxico","El caracter : '"+yytext()+"' no pertenece al lenguaje StatPy Convertor", Integer.toString(yyline), Integer.toString(yycolumn+1)));
        String errLex = "Error lexico : '"+yytext()+"' en la linea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}