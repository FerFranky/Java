/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alexico.Prueba;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Fernando Olmos
 */
public class Analizador {
    public static void main (String[] args){
    Scanner scanner = new Scanner(System.in);
    //Contadores
    int contador=0,con=0,lineas=1;
    //Variable rompe ciclos
    boolean hola = false;
    
    boolean fin=false;
    String o="" ;
    //Arreglo para guardar los tokens
    String evaluarLineas[] = new String[1000];
    //Estado inicial del arreglo
evaluarLineas[0]="";
//Tabla de Tokens
    String tablaTokens = (""
            + "(void)|(main)|([(|)]+)|([{|}]+)"
            + "|(int)|(double)|(boolean)|(string)"
            +"|(for)|(while)|(if)|(else)|(escribir)|(leer)"
            + "|(endprogram)"
            + "|([a-zA-Z]+)|([0-9]+)|([<|>|=|!=|<=|>=|==])|(;)|([+|-|*|/]+)|('|')"
            + "(=>)");
    String texto="";
    //Ciclo para recibir todas las lineas de codigo
    while(fin!=true){
        //Fin del ciclo 
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
    //Procedimiento para analisis lexico
    System.out.println("**********************************Analisis lexico************************************************");
    while(i<=con){
       texto=evaluarLineas[i];

        Matcher mat = p.matcher(texto);
        
        i++;
    while(mat.find()){
        //Validaciones para determinar el tipo de token introducido
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
        String tokenAsig = mat.group(22);
        if(tokenCom != null){
            System.out.println("Asignacion a variables declaradas: "+tokenCom);
        }
        
        contador++;
    }
    }
i=0;
//Rutinas Para generar un analisis sintactico
System.out.println("*********************************************Esquema de generacion***************************************");
    
while(i<=con){
       texto=evaluarLineas[i];
//System.out.println("linea"+evaluarLineas[i]);
//Validaciones de cada secuancia segun sus sintaxis
       
        try{
            //Analisis de metodos y clases
          if(evaluarLineas[i].equals("void")&&evaluarLineas[i+1].equals("main")&&evaluarLineas[i+2].equals("()")&&evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis correcta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+evaluarLineas[i+2]+evaluarLineas[i+3]);
//            i=i+1;
        }else if(evaluarLineas[i].equals("void")&&!evaluarLineas[i+1].equals("main")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("()")&&evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis correcta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+evaluarLineas[i+2]+evaluarLineas[i+3]);
//            i=i+1;
        }else  if(evaluarLineas[i].equals("void")&&!evaluarLineas[i+1].equals("main")&&evaluarLineas[i+2].equals("()")&&evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" ->usar main despues de void");
//            i++;
        }else if(evaluarLineas[i].equals("void")&&evaluarLineas[i+1].equals("main")&&!evaluarLineas[i+2].equals("()")&&evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" ->usar () despues de main");
//            i++;
        }else if(evaluarLineas[i].equals("void")&&evaluarLineas[i+1].equals("main")&&evaluarLineas[i+2].equals("()")&&!evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" ->usar { despues de ()");
//            i++;
        }else if(evaluarLineas[i].equals("void")&&evaluarLineas[i+1].equals("main")&&!evaluarLineas[i+2].equals("()")&&!evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" ->usar () { despues de main");
//            i++;
        }else if(evaluarLineas[i].equals("void")&&!evaluarLineas[i+1].equals("main")&&!evaluarLineas[i+2].equals("()")&&!evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" ->usar main () { despues de void");
//            i++;
        }else if(evaluarLineas[i].equals("void")&&(!evaluarLineas[i+1].equals("main")&&!evaluarLineas[i].equals(""))&&evaluarLineas[i+2].equals("()")&&evaluarLineas[i+3].equals("{")){
            System.out.println("Sintaxis correcta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+evaluarLineas[i+2]+evaluarLineas[i+3]);
//            i=i+1;
        }
         /*
          }*/
          // Para enteros
         if(evaluarLineas[i].equals("int")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&!evaluarLineas[i+3].equals("")&&evaluarLineas[i+4].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]);
//         i=i+1; 
         } else if(evaluarLineas[i].equals("int")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&!evaluarLineas[i+3].equals("")&&!evaluarLineas[i+4].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+"\n ->Utilizar int_espacio_var_espacio_=_espacio_val/var_espacio_; para terminar linea");
//         i++; 
         } else if(evaluarLineas[i].equals("int")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]);
//              i=i+1;
          }else if(evaluarLineas[i].equals("int")&&!evaluarLineas[i+1].equals("")&&!evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" ->Utilizar int_espacio_var_espacio_; para terminar linea");
//             i++;
          }
         // para double
         if(evaluarLineas[i].equals("double")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&!evaluarLineas[i+3].equals("")&&evaluarLineas[i+4].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]);
//         i=i+1; 
         } else if(evaluarLineas[i].equals("double")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&!evaluarLineas[i+3].equals("")&&!evaluarLineas[i+4].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+"\n ->Utilizar int_espacio_var_espacio_=_espacio_val/var_espacio_; para terminar linea");
//         i++; 
         } else if(evaluarLineas[i].equals("double")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]);
//              i=i+1;
          }else if(evaluarLineas[i].equals("double")&&!evaluarLineas[i+1].equals("")&&!evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" ->Utilizar int_espacio_var_espacio_; para terminar linea");
//             i++;
          }
         //Para boolean
         if(evaluarLineas[i].equals("boolean")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&(evaluarLineas[i+3].equals("true")||evaluarLineas[i+3].equals("false"))&&evaluarLineas[i+4].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]);
//         i=i+1; 
         } else if(evaluarLineas[i].equals("boolean")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&(evaluarLineas[i+3].equals("true")||evaluarLineas[i+3].equals("false"))&&!evaluarLineas[i+4].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+"\n ->Utilizar int_espacio_var_espacio_=_espacio_val/var_espacio_; para terminar linea");
//         i++; 
         } else if(evaluarLineas[i].equals("boolean")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]);
//              i=i+1;
          }else if(evaluarLineas[i].equals("boolean")&&!evaluarLineas[i+1].equals("")&&!evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" ->Utilizar int_espacio_var_espacio_; para terminar linea");
//             i++;
          }
         //Para cadenas de texto
         if(evaluarLineas[i].equals("string")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&evaluarLineas[i+3].equals("'")&&!evaluarLineas[i+4].equals("")&&evaluarLineas[i+5].equals("'")&&evaluarLineas[i+6].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]);
//         i=i+1; 
         } else if(evaluarLineas[i].equals("string")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals("=")&&evaluarLineas[i+3].equals("'")&&!evaluarLineas[i+4].equals("")&&evaluarLineas[i+5].equals("'")&&!evaluarLineas[i+6].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+"\n ->Utilizar int_espacio_var_espacio_=_espacio_val/var_espacio_; para terminar linea");
//         i++; 
         } else if(evaluarLineas[i].equals("string")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis correcta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]);
//              i=i+1;
          }else if(evaluarLineas[i].equals("string")&&!evaluarLineas[i+1].equals("")&&!evaluarLineas[i+2].equals(";")){
              System.out.println("Sintxis incorrecta: "+evaluarLineas[i]+ " "+evaluarLineas[i+1]+ " "+evaluarLineas[i+2]+" ->Utilizar int_espacio_var_espacio_; para terminar linea");
//             i++;
          }
         //Declaracion de esvritura en pantalla
         if(evaluarLineas[i].equals("escribir")&&evaluarLineas[i+1].equals("'")&&!evaluarLineas[i+2].equals("")&&evaluarLineas[i+3].equals("'")&&evaluarLineas[i+4].equals(";")){
             System.out.println("Escritura en pantalla correcta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]);
//         i++;
         }else if(evaluarLineas[i].equals("escribir")&&(!evaluarLineas[i+1].equals("'")||evaluarLineas[i+2].equals("")||!evaluarLineas[i+3].equals("'")||!evaluarLineas[i+4].equals(";"))){
             System.out.println("Escritura en pantalla incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]);
//         i++;
         }
         //Declaracion lectura en variables
         if (evaluarLineas[i].equals("leer")&&!evaluarLineas[i+1].equals("")&&evaluarLineas[i+2].equals(";")){
             System.out.println("Lectura de variable con exito: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]);
//         i++;
         }else if(evaluarLineas[i].equals("leer")&&(evaluarLineas[i+1].equals("")||!evaluarLineas[i+2].equals(";"))){
             System.out.println("Lectura de variable incorrecta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]);
//         i++;
         }
         //Declaracion ciclo for
         if(evaluarLineas[i].equals("for")&&evaluarLineas[i+1].equals("(")&&!evaluarLineas[i+2].equals("")&&evaluarLineas[i+3].equals("=")&&!evaluarLineas[i+4].equals("")&&evaluarLineas[i+5].equals(";")&&!evaluarLineas[i+6].equals("")&&(evaluarLineas[i+7].equals("<")||evaluarLineas[i+7].equals(">")||evaluarLineas[i+7].equals("<=")||evaluarLineas[i+7].equals(">=")||evaluarLineas[i+7].equals("="))&&!evaluarLineas[i+8].equals("")&&evaluarLineas[i+9].equals(";")&&!evaluarLineas[i+10].equals("")&&(evaluarLineas[i+11].equals("++")||evaluarLineas[i+11].equals("--"))&&evaluarLineas[i+12].equals(";")&&evaluarLineas[i+13].equals(")")&&evaluarLineas[i+14].equals("{")){
             //(evaluarLineas[i+4].equals("<")||evaluarLineas[i+4].equals(">")||evaluarLineas[i+4].equals("<=")||evaluarLineas[i+4].equals(">=")||evaluarLineas[i+4].equals("="))
        System.out.println("Sentencia For correcta"+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]+" "+evaluarLineas[i+7]+" "+evaluarLineas[i+8]+" "+evaluarLineas[i+9]+" "+evaluarLineas[i+10]+" "+evaluarLineas[i+11]+" "+evaluarLineas[i+12]+" "+evaluarLineas[i+13]+" "+evaluarLineas[i+14]);
//         i++;
         }
         if(evaluarLineas[i].equals("for")&&(!evaluarLineas[i+1].equals("(")||evaluarLineas[i+2].equals("")||!evaluarLineas[i+3].equals("=")||evaluarLineas[i+4].equals("")||!evaluarLineas[i+5].equals(";")||evaluarLineas[i+6].equals("")||!(evaluarLineas[i+7].equals("<")||evaluarLineas[i+7].equals(">")||evaluarLineas[i+7].equals("<=")||evaluarLineas[i+7].equals(">=")||evaluarLineas[i+7].equals("="))||evaluarLineas[i+8].equals("")||!evaluarLineas[i+9].equals(";")||evaluarLineas[i+10].equals("")||!(evaluarLineas[i+11].equals("++")||evaluarLineas[i+11].equals("--"))||!evaluarLineas[i+12].equals(";")||!evaluarLineas[i+13].equals(")")||!evaluarLineas[i+14].equals("{"))){
          
          o= evaluarLineas[i];
             //(evaluarLineas[i+4].equals("<")||evaluarLineas[i+4].equals(">")||evaluarLineas[i+4].equals("<=")||evaluarLineas[i+4].equals(">=")||evaluarLineas[i+4].equals("="))
        System.out.println("Error for: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]+" "+evaluarLineas[i+7]+" "+evaluarLineas[i+8]+" "+evaluarLineas[i+9]+" "+evaluarLineas[i+10]+" "+evaluarLineas[i+11]+" "+evaluarLineas[i+12]+" "+evaluarLineas[i+13]+" "+evaluarLineas[i+14]+" "+"\nSecuencia sugerida-> for_(_var_=_val/var_;_var_OpA_val/var_;_var_++_;_)_{");
//         i++;
         }
         //declaracion if
         if(evaluarLineas[i].equals("if")&&evaluarLineas[i+1].equals("(")&&!evaluarLineas[i+2].equals("")&&(evaluarLineas[i+3].equals("==")||evaluarLineas[i+3].equals("!=")||evaluarLineas[i+3].equals("<=")||evaluarLineas[i+3].equals(">=")||evaluarLineas[i+3].equals("<")||evaluarLineas[i+3].equals(">"))&&!evaluarLineas[i+4].equals("")){
             if(evaluarLineas[i+5].equals(")")&&evaluarLineas[i+6].equals("{")){
                 System.out.println("Sentancia If correcta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]);
//             i++;
             }else if((evaluarLineas[i+5].equals("||")||evaluarLineas[i+5].equals("&&"))&&!evaluarLineas[i+6].equals("")&&(evaluarLineas[i+7].equals("==")||evaluarLineas[i+7].equals("!=")||evaluarLineas[i+7].equals("<=")||evaluarLineas[i+7].equals(">=")||evaluarLineas[i+7].equals("<")||evaluarLineas[i+7].equals(">"))&&!evaluarLineas[i+8].equals("")&&evaluarLineas[i+9].equals(")")&&evaluarLineas[i+10].equals("{")){
                 System.out.println("Sentancia If doble correcta: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]+" "+evaluarLineas[i+7]+" "+evaluarLineas[i+8]+" "+evaluarLineas[i+9]+" "+evaluarLineas[i+10]);
//             i++;
             }else {
                  System.out.println("Sentancia if incorrecta "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]);
                  System.out.println("Solo se pueden hace dos comparaciones a la vez en caso de ocupar mas se deben anidar sentancias");
                  System.out.println("Secuencias sugeridas: 1-> if_(_var_OpC_var/val_)_{ o bien 2-> if_(_var_OpC_var/val_OpL_var_OpC_var/val_)_{");
//             i++;
             }
         }else if (evaluarLineas[i].equals("if")&&(!evaluarLineas[i+1].equals("(")||evaluarLineas[i+2].equals("")||(!evaluarLineas[i+3].equals("==")||!evaluarLineas[i+3].equals("!=")||!evaluarLineas[i+3].equals("<=")||!evaluarLineas[i+3].equals(">=")||!evaluarLineas[i+3].equals("<")||!evaluarLineas[i+3].equals(">"))&&evaluarLineas[i+4].equals("")||!evaluarLineas[i+5].equals(")")||!evaluarLineas[i+6].equals("{")||!(evaluarLineas[i+5].equals("||")||evaluarLineas[i+5].equals("&&"))||evaluarLineas[i+6].equals("")||!(evaluarLineas[i+7].equals("==")||evaluarLineas[i+7].equals("!=")||evaluarLineas[i+7].equals("<=")||evaluarLineas[i+7].equals(">=")||evaluarLineas[i+7].equals("<")||evaluarLineas[i+7].equals(">"))||evaluarLineas[i+8].equals("")||!evaluarLineas[i+9].equals(")")||!evaluarLineas[i+10].equals("{"))){
                System.out.println("Sentancia if incorrecta "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]);
                System.out.println("Solo se pueden hace dos comparaciones a la vez en caso de ocupar mas se deben anidar sentancias");
                System.out.println("Secuencias sugeridas: 1-> if_(_var_OpC_var/val_)_{ o bien 2-> if_(_var_OpC_var/val_OpL_var_OpC_var/val_)_{");
//         i++;
         }
         //Declaracion else
         if(evaluarLineas[i].equals("}")&&evaluarLineas[i+1].equals("else")&&(evaluarLineas[i+2].equals("{")||evaluarLineas[i+2].equals("if"))){
             System.out.println("else declarado correctamente: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]);
//         i++;
         }else if(!evaluarLineas[i].equals("}")&&evaluarLineas[i+1].equals("else")&&!(evaluarLineas[i+2].equals("{")||evaluarLineas[i+2].equals("if"))){
             System.out.println("else declarado incorrectamente: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]);
//         i++;
         }else if(evaluarLineas[i].equals("}")&&evaluarLineas[i+1].equals("else")&&!(evaluarLineas[i+2].equals("{")||evaluarLineas[i+2].equals("if"))){
             System.out.println("else declarado incorrectamente: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]);
//         i++;
         }else if(!evaluarLineas[i].equals("}")&&evaluarLineas[i+1].equals("else")&&(evaluarLineas[i+2].equals("{")||evaluarLineas[i+2].equals("if"))){
             System.out.println("else declarado incorrectamente: "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]);
//         i++;
         }
         //Declaracion while
         if(evaluarLineas[i].equals("while")&&evaluarLineas[i+1].equals("(")&&!evaluarLineas[i+2].equals("")&&(evaluarLineas[i+3].equals("==")||evaluarLineas[i+3].equals("!=")||evaluarLineas[i+3].equals("<=")||evaluarLineas[i+3].equals(">=")||evaluarLineas[i+3].equals("<")||evaluarLineas[i+3].equals(">"))&&!evaluarLineas[i+4].equals("")&&evaluarLineas[i+5].equals(")")&&evaluarLineas[i+6].equals("{")){
             System.out.println("while correcto "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]);
//         i++;
         }else if(evaluarLineas[i].equals("while")&&(!evaluarLineas[i+1].equals("(")||evaluarLineas[i+2].equals("")||!(evaluarLineas[i+3].equals("==")||evaluarLineas[i+3].equals("!=")||evaluarLineas[i+3].equals("<=")||evaluarLineas[i+3].equals(">=")||evaluarLineas[i+3].equals("<")||evaluarLineas[i+3].equals(">"))||evaluarLineas[i+4].equals("")||!evaluarLineas[i+5].equals(")")||!evaluarLineas[i+6].equals("{"))){
             System.out.println("while incorrecto "+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]+" "+evaluarLineas[i+4]+" "+evaluarLineas[i+5]+" "+evaluarLineas[i+6]);
//         i++;
         }
         //Declaracion de operaciones aritmeticas
         if(!evaluarLineas[i].equals("")&&(evaluarLineas[i+1].equals("+")||evaluarLineas[i+1].equals("-")||evaluarLineas[i+1].equals("/")||evaluarLineas[i+1].equals("*"))&&!evaluarLineas[i+2].equals("")&&evaluarLineas[i+3].equals(";")){
             System.out.println("Asignacion correcta"+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]);
         }/*else if(!evaluarLineas[i].equals("")&&!(evaluarLineas[i].equals("for")||evaluarLineas[i].equals("while")||evaluarLineas[i].equals("if")||evaluarLineas[i].equals("{")||evaluarLineas[i].equals("}")||evaluarLineas[i].equals("+")||evaluarLineas[i].equals("-")||evaluarLineas[i].equals("*")||evaluarLineas[i].equals("/")||evaluarLineas[i].equals("<")||evaluarLineas[i].equals(">")||evaluarLineas[i].equals("=")||evaluarLineas[i].equals("escribir")||evaluarLineas[i].equals("void")||evaluarLineas[i].equals("int")||evaluarLineas[i].equals("double")||evaluarLineas[i].equals("boolean")||evaluarLineas[i].equals("string")||evaluarLineas[i].equals("endprogram")||(evaluarLineas[i+1].equals("+"))||(evaluarLineas[i+1].equals("-")||(evaluarLineas[i+1].equals("*"))||(evaluarLineas[i+1].equals("/"))||evaluarLineas[i+3].equals("")||evaluarLineas[i+4].equals(";")))){
             System.out.println("asignacion inconrrecta"+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]);
         }*/
         //Asignacion de variables
        /* if(!evaluarLineas[i].matches("$")&&!evaluarLineas[i].equals("for")&&!evaluarLineas[i].equals("while")&&!evaluarLineas[i].equals("if")&&!evaluarLineas[i].equals("{")&&!evaluarLineas[i].equals("}")&&!evaluarLineas[i].equals("+")&&!evaluarLineas[i].equals("-")&&!evaluarLineas[i].equals("*")&&!evaluarLineas[i].equals("/")&&!evaluarLineas[i].equals("<")&&!evaluarLineas[i].equals(">")&&!evaluarLineas[i].equals("=")&&!evaluarLineas[i].equals("escribir")&&!evaluarLineas[i].equals("void")&&!evaluarLineas[i].equals("int")&&!evaluarLineas[i].equals("double")&&!evaluarLineas[i].equals("boolean")&&!evaluarLineas[i].equals("string")&&!evaluarLineas[i].equals("endprogram")&&evaluarLineas[i+1].equals("=>")&&!evaluarLineas[i+2].equals("")&&evaluarLineas[i+3].equals(";")){
             System.out.println("asignacion conrrecta");
         }
         if(!evaluarLineas[i].equals("$")&&!evaluarLineas[i].equals("for")&&!evaluarLineas[i].equals("while")&&!evaluarLineas[i].equals("if")&&!evaluarLineas[i].equals("{")&&!evaluarLineas[i].equals("}")&&!evaluarLineas[i].equals("+")&&!evaluarLineas[i].equals("-")&&!evaluarLineas[i].equals("*")&&!evaluarLineas[i].equals("/")&&!evaluarLineas[i].equals("<")&&!evaluarLineas[i].equals(">")&&!evaluarLineas[i].equals("=")&&!evaluarLineas[i].equals("escribir")&&!evaluarLineas[i].equals("void")&&!evaluarLineas[i].equals("int")&&!evaluarLineas[i].equals("double")&&!evaluarLineas[i].equals("boolean")&&!evaluarLineas[i].equals("string")&&!evaluarLineas[i].equals("endprogram")&&(!evaluarLineas[i+1].equals("=>")||evaluarLineas[i+2].equals("")||!evaluarLineas[i+3].equals(";"))){
             System.out.println("asignacion inconrrecta"+evaluarLineas[i]+" "+evaluarLineas[i+1]+" "+evaluarLineas[i+2]+" "+evaluarLineas[i+3]);
         }*/
        }catch(Exception e){
           // System.out.println("Error fatal en lectura de : "+o);
        }
        
        i++;

    }
    }
}