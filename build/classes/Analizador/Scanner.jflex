
package Analizador;
import java_cup.runtime.*;

%%  

%{
    //Codigo de usuario 
    

%}

%class scanner //Define como trabajara el scanner
%cup    //trabajar con cup
%public     //tipo publico 
%line       //conteo de lineas - linea por linea
%char       //caracter por caracter 
%unicode    //tipo de codificacion para que acepte la ene u otro caracter
%ignorecase //case indispensable

%init{ 
    yyline = 1;
    yycolumn =1;
%init} 


// --------------------->  Expresiones Regulares  -----------------------------
ENTERO = [0-9]+
DECIMAL = [0-9]+("."[  |0-9]+)?
LETRA = [a-zA-ZÑñ]
ID = {LETRA}({LETRA}|{ENTERO}|"_")*
CADENA = [\"][^\"\n]+[\"]
CADENA1 = [\"][^0-9("."[  |0-9]+)?\"\n]+[\"]
SPACE = [\ \r\t\f]
ENTER = \r|\n|\r\n\
CARACTER = [^\r\n]
COMENTARIO_INLINE = "//" {CARACTER}* {ENTER}?
COMENTARIO_MULTI = \/\*[^*]*\*+([^/*][^*]*\*+)*\/
//simbolos
LLA_IZQ = "{"
LLA_DER = "}"
MENOR_QUE = "<"
MAYOR_QUE = ">"
COMILLA_DOBLE = "\""
DOS_PUNTOS = ":"
COMA  = ","


%%

//-------------> Reglas lexicas  -------------------------------
<YYINITIAL> {LLA_IZQ}  { return new Symbol(sym.LLA_IZQ, yyline, yycolumn, yytext());  }
<YYINITIAL> {LLA_DER}  { return new Symbol(sym.LLA_DER, yyline, yycolumn, yytext());  }
<YYINITIAL> {MENOR_QUE}  { return new Symbol(sym.MENOR_QUE, yyline, yycolumn, yytext());  }
<YYINITIAL> {MAYOR_QUE}  { return new Symbol(sym.MAYOR_QUE, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMILLA_DOBLE}  { return new Symbol(sym.COMILLA_DOBLE, yyline, yycolumn, yytext());  }
<YYINITIAL> {DOS_PUNTOS}  { return new Symbol(sym.DOS_PUNTOS, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMA}  { return new Symbol(sym.COMA, yyline, yycolumn, yytext());  }

<YYINITIAL> {ENTERO}  { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());  }
<YYINITIAL> {DECIMAL}  { return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());  }
<YYINITIAL> {CADENA}  { return new Symbol(sym.CADENA, yyline, yycolumn, yytext());  }
<YYINITIAL> {ID}  { return new Symbol(sym.ID, yyline, yycolumn, yytext());  }


<YYINITIAL> {SPACE}  { /*Espacion en blanco , ignorados*/}
<YYINITIAL> {ENTER}  {/*Saltos de linea, ignorados*/}




// ---------> Ignorados
<YYINITIAL> {COMENTARIO_MULTI}  {/*Comentario multilinea, ignorados*/ System.out.println("Comentario multilinea: "+yytext() ); }
<YYINITIAL> {COMENTARIO_INLINE}  {/*Comentario linea, ignorados*/ System.out.println("Comentario linea: "+yytext() ); }

//----------> Errores lexicos

<YYINITIAL> . {
    String errLex = "Error lexico : '"+yytext()+"' en la linea: "+(yyline+1)+" y columna: "+(yycolumn+1);
    System.out.println(errLex);
}