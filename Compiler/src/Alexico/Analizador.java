/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alexico;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * 
 */
public class Analizador {
    public static void main (String[]args){
    Scanner scanner = new Scanner(System.in);
    int contador=0,con=0,lineas=1;
    boolean fin=false;
    String evaluarLineas[] = new String[1000];
evaluarLineas[0]="";
    String tablaTokens = (""
            + "(void)|(main)|([(|)]+)|([{|}]+)"
            + "|(int)|(double)|(boolean)|(string)"
            +"|(for)|(while)|(if)|(else)|(escribir)|(leer)"
            + "|(endprogram)"
            + "|([a-zA-Z]+)|([0-9]+)|([<|>|=|!=|<=|>=|==])|(;)|([+|-|*|/]+)|('|')"
            + "");
    String texto = "void main int perro double hola";
    while(fin!=true){

        if(evaluarLineas[con].equals("endprogram")){
            fin=true;
           
        }else{
                  
            evaluarLineas[contador]=scanner.next();
            contador++;
            con=contador-1;
        }
    }
    Pattern p = Pattern.compile(tablaTokens);
    
    //con=contador;
    contador=0;
    int i=0;
    while(i<=con){
       texto=evaluarLineas[i];

       Matcher mat = p.matcher(texto);
        
        i++;
    while(mat.find()){
        String tokenVoid = mat.group(1);
        if(tokenVoid != null){
            System.out.println("Metodo/Clase vacia: "+tokenVoid);
        }
        String tokenPrin = mat.group(2);
        if(tokenPrin != null){
            System.out.println("Declaracion clase principal: "+tokenPrin);
        }        
        String tokenParentesis = mat.group(3);
        if(tokenParentesis != null){
            System.out.println("Seccion de parametros: "+tokenParentesis);
        }
                
                String tokenLlaves = mat.group(4);
        if(tokenLlaves != null){
            System.out.println("Inicio/fin de Clase/Metodo: "+tokenLlaves);
        }
        
        String tokenInt = mat.group(5);
        if(tokenInt != null){
            System.out.println("Declaracion tipo entero: "+tokenInt);
        }
        String tokenDouble = mat.group(6);
        if(tokenDouble != null){
            System.out.println("Declaracion tipo decimal: "+tokenDouble);
        }
        String tokenBool = mat.group(7);
        if(tokenBool != null){
            System.out.println("Declaracion tipo Booleano: "+tokenBool);
        }
        String tokenStg = mat.group(8);
        if(tokenStg != null){
            System.out.println("Declaracion tipo String: "+tokenStg);
        }
        String tokenPRF = mat.group(9);
        if(tokenPRF != null){
            System.out.println("Palabra reservada para: "+tokenPRF);
        }
        String tokenPRW = mat.group(10);
        if(tokenPRW != null){
            System.out.println("Palabra reservada mientras: "+tokenPRW);
        }
        String tokenPRS = mat.group(11);
        if(tokenPRS != null){
            System.out.println("Palabra reservada si: "+tokenPRS);
        }
        String tokenPRSN = mat.group(12);
        if(tokenPRSN != null){
            System.out.println("Palabra reservada sino: "+tokenPRSN);
        }
        String tokenLetra = mat.group(13);
        if(tokenLetra != null){
            System.out.println("Escritura: "+tokenLetra);
        }
        String tokenEsc = mat.group(14);
        if(tokenEsc != null){
            System.out.println("Lectura: "+tokenEsc);
        }
        String tokenEndP = mat.group(15);
        if(tokenEndP != null){
            System.out.println("Lectura fin del programa: "+tokenEndP);
        }
        String tokenLeer = mat.group(16);
        if(tokenLeer != null){
            System.out.println("Declaracion tipo Alfabetico: "+tokenLeer);
        }
        String tokenNumeros = mat.group(17);
        if(tokenNumeros != null){
            System.out.println("Declaracion tipo Numerico: "+tokenNumeros);
        }
        String tokenComp = mat.group(18);
        if(tokenComp != null){
            System.out.println("Declaracion de operaciones de Comparacion: "+tokenComp);
        }
        String tokenPC = mat.group(19);
        if(tokenPC != null){
            System.out.println("Fin de linea: "+tokenPC);
        }
        String tokenOpA = mat.group(20);
        if(tokenOpA != null){
            System.out.println("Operadores Aritmeticos: "+tokenOpA);
        }
        String tokenCom = mat.group(21);
        if(tokenCom != null){
            System.out.println("Apertura/ cierre de cadena: "+tokenCom);
        }
        
        contador++;
    }
    }
}
}